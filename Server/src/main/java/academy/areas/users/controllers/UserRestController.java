package academy.areas.users.controllers;

import academy.areas.users.entities.Role;
import academy.areas.users.entities.User;
import academy.areas.users.model.bindingModels.UserBindingModel;
import academy.areas.users.model.bindingModels.UserLoginBindingModel;
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

    @Autowired
    public UserRestController(final UserServices userServices, final RoleServices roleServices) {
        this.userServices = userServices;
        this.roleServices = roleServices;
    }

    @PostMapping("/login")
    public User login(@RequestBody UserLoginBindingModel bindingModel){
        UserDetails principal = null;
        return null;
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
}
