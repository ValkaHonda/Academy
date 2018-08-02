package academy.areas.courses.controllers;

import academy.areas.courses.entities.Course;
import academy.areas.courses.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseRestController {
    private CourseServices courseServices;

    @Autowired
    public CourseRestController(final CourseServices courseServices) {
        this.courseServices = courseServices;
    }

    @GetMapping("/getAll")
    public List<Course> getCourses(){
        return this.courseServices.getAllCourses();
    }
    @GetMapping("/getById/{id}")
    public Course getCourse(@PathVariable final Integer id){
        return this.courseServices.getCourse(id);
    }
    @PostMapping("/create")
    public @ResponseBody Integer createCourse(@RequestBody Course course){
        return this.courseServices.createCourse(course);
    }
    @PutMapping("/update")
    public void updateCourse(@RequestBody Course course){
        this.courseServices.createCourse(course);
    }
    @DeleteMapping("/delete/{id}")
    public void disableCourse(@PathVariable final Integer id){
        this.courseServices.disableCourse(id);
    }
}
