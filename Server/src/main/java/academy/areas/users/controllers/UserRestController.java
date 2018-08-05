package academy.areas.users.controllers;

import academy.areas.users.models.viewModels.UserViewModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
    @GetMapping("/getById/{id}")
    public UserViewModel getUserById(@PathVariable final Integer id){
        return null;
    }
    @GetMapping("/getAll")
    public List<UserViewModel> getAllUsers(){
        return null;
    }
}
