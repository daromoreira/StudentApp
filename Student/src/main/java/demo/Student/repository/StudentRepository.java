package demo.Student.repository;

import demo.Student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  @Query(value = "SELECT s FROM Student s WHERE s.email = ?1", nativeQuery = true)
  Optional<Student> findStudentByEmail(String email);
}
