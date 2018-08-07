package academy.areas.users.controllers;

import academy.areas.courses.entities.Course;
import academy.areas.courses.services.CourseServices;
import academy.areas.users.entities.Role;
import academy.areas.users.entities.User;
import academy.areas.users.model.bindingModels.UserBindingModel;
import academy.areas.users.model.bindingModels.UserLoginBindingModel;
import academy.areas.users.model.bindingModels.UserUpdateBindingModel;
import academy.areas.users.models.viewModels.UserViewModel;
import academy.areas.users.services.RoleServices;
import academy.areas.users.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
    private UserServices userServices;
    private RoleServices roleServices;
    private CourseServices courseServices;

    @Autowired
    public UserRestController(final UserServices userServices, final RoleServices roleServices,
                              final CourseServices courseServices) {
        this.userServices = userServices;
        this.roleServices = roleServices;
        this.courseServices = courseServices;
    }

    @GetMapping("/getById/{id}")
    public UserViewModel getUserById(@PathVariable final Integer id){
        return this.userServices.getUserById(id);
    }

    @GetMapping("/getAll")
    public List<UserViewModel> getAllUsers(){
        return this.userServices.getAllUsers();
    }

    @PostMapping("/register")
    public @ResponseBody UserViewModel registerUser(@RequestBody UserBindingModel userBindingModel){
        Role role = this.roleServices.getRoleByName("ROLE_STUDENT");
        return this.userServices.registerUser(userBindingModel,role);
    }

    @PutMapping("/update")
    public @ResponseBody UserViewModel updateUser(@RequestBody UserUpdateBindingModel userBindingModel){
        return this.userServices.updateUser(userBindingModel);
    }

    @PostMapping("/assignToCourse/{courseId}")
    public @ResponseBody UserViewModel assignToCourse(@PathVariable final Integer courseId,
                                                      @RequestBody final UserBindingModel userBindingModel){
        User user = this.userServices.getUserEntityById(userBindingModel.getId());
        Course course = this.courseServices.getCourseEntityById(courseId);
        return this.userServices.assignStudentToCourse(user,course);
    }
}
