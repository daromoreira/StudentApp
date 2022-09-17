package demo.Student;

import demo.Student.entity.Student;
import demo.Student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository){
    return args -> {
      Student mariam = new Student(
          1L,
          "Mariam",
          "mariam@gmail.com",
          LocalDate.of(2000, Month.APRIL,4)
      );
      Student alex = new Student(
          2L,
          "Alexander",
          "alex@gmail.com",
          LocalDate.of(2004, Month.APRIL,8)
      );
      repository.saveAll(
          List.of(mariam, alex)
      );
    };
  }
}