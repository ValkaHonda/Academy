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
        return null;
    }
    @GetMapping("/getById/{id}")
    public Course getCourse(@PathVariable final Integer id){
        return null;
    }
    @PostMapping("/create")
    public @ResponseBody Integer createCourse(@RequestBody Course course){
        return null;
    }
    @PutMapping("/update")
    public void updateCourse(@RequestBody Course course){

    }
    @DeleteMapping("/delete/{id}")
    public void disableCourse(@PathVariable final Integer id){

    }
}
