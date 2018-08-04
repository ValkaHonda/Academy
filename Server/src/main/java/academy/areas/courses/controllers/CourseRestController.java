package academy.areas.courses.controllers;

import academy.areas.courses.models.bindingModel.CourseBindingModel;
import academy.areas.courses.models.viewModels.CourseViewModel;
import academy.areas.courses.services.CourseServices;
import academy.areas.modules.entities.Module;
import academy.areas.modules.services.ModuleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseRestController {
    private CourseServices courseServices;
    private ModuleServices moduleServices;

    @Autowired
    public CourseRestController(final CourseServices courseServices) {
        this.courseServices = courseServices;
    }



    @GetMapping("/getById/{id}")
    public CourseViewModel getCourseById(@PathVariable final Integer id){
        return this.courseServices.getCourseById(id);
    }
    @GetMapping("/getAll")
    public List<CourseViewModel> getCourses(){
        return this.courseServices.getAllCourses();
    }
    @PostMapping("/create/{moduleId}")
    public @ResponseBody  CourseViewModel createCourse(@RequestBody final CourseBindingModel courseBindingModel,
                                                       @PathVariable final Integer moduleId){
        Module module = this.moduleServices.getModuleEntityById(moduleId);
        if (this.moduleServices.exists(moduleId)){
            return this.courseServices.createCourse(courseBindingModel,module);

        }
        return null;
    }
    @PutMapping("/update")
    public @ResponseBody CourseViewModel updateCourse(@RequestBody CourseBindingModel courseBindingModel){
        return this.courseServices.updateCourse(courseBindingModel);
    }
}
