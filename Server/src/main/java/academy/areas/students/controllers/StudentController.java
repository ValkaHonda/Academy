package academy.areas.students.controllers;

import academy.areas.students.entities.Student;
import academy.areas.students.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class StudentController {
    private StudentServices studentServices;

    @Autowired
    public StudentController(final StudentServices studentServices) {
        this.studentServices = studentServices;
    }
/*
    @GetMapping("/")
    public List<Student> getStudents(){
        return this.studentServices.getAllStudents();
    }
*/
}
