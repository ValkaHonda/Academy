package academy.areas.courses.controllers;

import academy.areas.courses.models.bindingModel.CourseBindingModel;
import academy.areas.courses.models.viewModels.CourseViewModel;
import academy.areas.courses.services.CourseServices;
import academy.areas.modules.entities.Module;
import academy.areas.modules.services.ModuleServices;
import academy.areas.users.entities.User;
import academy.areas.users.services.UserServices;
import academy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/course")
public class CourseRestController {
    private CourseServices courseServices;
    private ModuleServices moduleServices;
    private UserServices userServices;

    @Autowired
    public CourseRestController(final CourseServices courseServices,
                                final ModuleServices moduleServices,
                                final UserServices userServices) {
        this.courseServices = courseServices;
        this.moduleServices = moduleServices;
        this.userServices = userServices;
    }

    @GetMapping("/getById/{id}")
    public CourseViewModel getCourseById(@PathVariable final Integer id){
        return this.courseServices.getCourseById(id);
    }

    @GetMapping("/getAll")
    public List<CourseViewModel> getCourses(){
        return this.courseServices.getAllCourses();
    }

    @GetMapping("/exists/{courseName}/{moduleName}")
    public @ResponseBody Boolean exists(@PathVariable("courseName") final String courseName,
                                        @PathVariable("moduleName") final String moduleName){
        return this.courseServices.exists(courseName,moduleName);
    }

    @GetMapping("/getByUserId/{userId}")
    public @ResponseBody List<CourseViewModel> getCoursesByUserId(@PathVariable final Integer userId){
        User user = this.userServices.getUserEntityById(userId);
        if (user != null){
            Set<User> users = new HashSet<>();
            users.add(user);
            return this.courseServices.getCoursesByUsers(users);
        }
        return null;

    }

    @PostMapping("/create/{moduleId}")
    public @ResponseBody  CourseViewModel createCourse(@RequestBody final CourseBindingModel courseBindingModel,
                                                       @PathVariable("moduleId") final Integer moduleId){
        Module module = this.moduleServices.getModuleEntityById(moduleId);
        if (module != null){
            return this.courseServices.createCourse(courseBindingModel,module);
        }
        return null;
    }

    @PutMapping("/update")
    public @ResponseBody CourseViewModel updateCourse(@RequestBody CourseBindingModel courseBindingModel){
        return this.courseServices.updateCourse(courseBindingModel);
    }
}
