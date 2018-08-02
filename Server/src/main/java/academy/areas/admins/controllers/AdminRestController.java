package academy.areas.admins.controllers;

import academy.areas.admins.entities.Admin;
import academy.areas.admins.services.AdminServices;
import academy.areas.courses.services.CourseServices;
import academy.areas.modules.services.ModuleServices;
import academy.areas.teachers.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminRestController {
    private AdminServices adminServices;
    private CourseServices courseServices;
    private ModuleServices moduleServices;

    @Autowired
    public AdminRestController(final AdminServices adminServices,
                               final CourseServices courseServices,
                               final ModuleServices moduleServices) {
        this.adminServices = adminServices;
        this.courseServices = courseServices;
        this.moduleServices = moduleServices;
    }

    @PostMapping("/create")
    public @ResponseBody Integer createAdmin(@RequestBody Admin admin){
        return this.adminServices.createAdmin(admin);
    }
    @GetMapping("/getAll")
    public List<Admin> getAllAdmins(){
        return this.adminServices.getAllAdmins();
    }
    @GetMapping("/getById/{id}")
    public Admin getAdmin(@PathVariable final Integer id){
        return this.adminServices.getById(id);
    }
    @PutMapping("/update")
    public void updateAdmin(@RequestBody Admin admin){
        this.adminServices.updateAdmin(admin);
    }
    @DeleteMapping("/delete/{id}")
    public void disableAdmin(@PathVariable final Integer id){
        this.adminServices.disableAdmin(id);
    }
    @PostMapping("/assignTeacherToCourse/{teacherId}/{courseId}")
    public void asignTeacherToCourse(@PathVariable("teacherId") final Integer teacherId,
                                     @PathVariable("courseId") final Integer courseId){
        this.courseServices.assignTeacherToCourse(teacherId,courseId);
    }
    @PostMapping("/removeTeacherFromCourse/{teacherId}/{courseId}")
    public void removeTeacherFromCourse(@PathVariable("teacherId") final Integer teacherId,
    @PathVariable("courseId") final Integer courseId){
        this.courseServices.removeTeacherFromCourse(teacherId,courseId);
    }
    @PostMapping("/addCourseToModule/{moduleId}/{courseId}")
    public void addCourseToModule(@PathVariable("moduleId") final Integer moduleId,
                                     @PathVariable("courseId") final Integer courseId){
        this.moduleServices.addCourseToModule(moduleId,courseId);
    }
    @PostMapping("/removeCourseFromModule/{moduleId}/{courseId}")
    public void removeCourseFromModule(@PathVariable("moduleId") final Integer moduleId,
                                  @PathVariable("courseId") final Integer courseId){
        this.moduleServices.removeCourseFromModule(moduleId,courseId);
    }
}
