package demo.Student.controller;

import demo.Student.entity.Student;
import demo.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
  @Autowired
  private final StudentService studentService;
  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  public List<Student> getStudents(){
    return studentService.getStudents();
  }

  @PostMapping
  public void registerNewStudent(@RequestBody @NonNull Student student){
    studentService.addNewStudent(student);
  }

  @PutMapping(path = "{studentId}")
  public void updateStudent(@RequestBody Student newEstudent, @PathVariable("studentId") Long studentId){
    studentService.updateStudent(newEstudent, studentId);
    //another example
  }
  @DeleteMapping(path = "{studentId}")
  public void  deleteStudent(@PathVariable("studentId") Long studentId){
    studentService.deleteStudent(studentId);
  }
}
