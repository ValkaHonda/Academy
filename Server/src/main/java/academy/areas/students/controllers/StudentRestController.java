package academy.areas.students.controllers;

import academy.areas.students.entities.Student;
import academy.areas.students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    private StudentService studentService;

    @Autowired
    public StudentRestController(final StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/allStudents")
    public List<Student> getStudents(){
        return this.studentService.getAllStudents();
    }
    @GetMapping("/findById/{id}")
    public Student getStudentById(@PathVariable final Integer id){
        return this.studentService.findStudentById(id);
    }
    @GetMapping("/findByUserName/{userName}")
    public Student getStudentByUserName(@PathVariable final String userName){
        return this.studentService.findStudentByUserName(userName);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable final Integer id){
        this.studentService.disableStudentById(id);
    }
    @PostMapping("/createStudent")
    public @ResponseBody int createStudent(@RequestBody Student student){
        this.studentService.addStudent(student);
        return this.studentService.findStudentByUserName(student.getUserName()).getId();
    }
    @PutMapping("/updateStudent")
    public void updateUser(@RequestBody Student student){
        this.studentService.updateStudent(student);
    }
}
