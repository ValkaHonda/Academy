package academy.areas.teachers.controllers;

import academy.areas.teachers.entities.Teacher;
import academy.areas.teachers.services.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherRestController {
    private TeacherServices teacherServices;

    @Autowired
    public TeacherRestController(final TeacherServices teacherServices) {
        this.teacherServices = teacherServices;
    }
    @PostMapping("/create")
    public Integer createTeacher(@RequestBody Teacher teacher){
        return this.teacherServices.createTeacher(teacher);
    }
    @GetMapping("/getAll")
    public List<Teacher> getAll(){
        return this.teacherServices.getAllTeachers();
    }
    @GetMapping("/getById/{id}")
    public Teacher getTeacher(@PathVariable final Integer id){
        return this.teacherServices.getTeacherById(id);
    }
    @PutMapping("/update")
    public void updateTeacher(@RequestBody Teacher teacher){
        this.teacherServices.updateTeacher(teacher);
    }
    @DeleteMapping("/delete/{id}")
    public void disableTeacher(@PathVariable Integer id){
        this.teacherServices.disableTeacher(id);
    }
}
