package academy.areas.admins.controllers;

import academy.areas.admins.entities.Admin;
import academy.areas.admins.services.AdminServices;
import academy.areas.teachers.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminRestController {
    private AdminServices adminServices;
    @Autowired
    public AdminRestController(final AdminServices adminServices) {
        this.adminServices = adminServices;
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
}
