package demo.Student.service;

import demo.Student.entity.Student;
import demo.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  private final StudentRepository studentRepository;
  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents(){
    return studentRepository.findAll();
  }

  public void addNewStudent(Student student){
    Optional<Student> optionalStudent = studentRepository.findStudentByEmail(student.getEmail());
    if (optionalStudent.isPresent()){
      throw new IllegalStateException("email taken");
    }
    studentRepository.save(student);
  }

  public void deleteStudent(Long studentId) {
    boolean exists = studentRepository.existsById(studentId);
    if (!exists)
      throw new IllegalStateException("student with id "+ studentId +" doesnt exist");

    studentRepository.deleteById(studentId);
  }
  @Transactional
  public void updateStudent(Student newStudent, Long studentId){
    boolean exists = studentRepository.existsById(studentId);
    if (!exists)
      throw new IllegalStateException("student with id "+ studentId +" doesnt exist");
    Student updatedStudent = studentRepository.getReferenceById(studentId);
    updatedStudent.setName(newStudent.getName());
    updatedStudent.setEmail(newStudent.getEmail());

    studentRepository.save(updatedStudent);
    //something
  }
}
