package academy.areas.teachers.controllers;

import academy.areas.teachers.services.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeacherRestController {
    private TeacherServices teacherServices;

    @Autowired
    public TeacherRestController(final TeacherServices teacherServices) {
        this.teacherServices = teacherServices;
    }
}
