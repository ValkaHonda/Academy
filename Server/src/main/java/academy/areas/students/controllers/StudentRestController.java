package academy.areas.students.controllers;

import academy.areas.students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentRestController {
    private StudentService studentService;

    @Autowired
    public StudentRestController(final StudentService studentService) {
        this.studentService = studentService;
    }
}
