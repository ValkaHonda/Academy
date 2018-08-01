package academy.areas.modules.controllers;

import academy.areas.modules.entities.Module;
import academy.areas.modules.services.ModuleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modules")
public class ModuleRestController {
    private ModuleServices moduleServices;

    @Autowired
    public ModuleRestController(final ModuleServices moduleServices) {
        this.moduleServices = moduleServices;
    }

    @GetMapping("/getById/{id}")
    public Module getModule(@PathVariable final Integer id){
        return null;
    }
    @GetMapping("/getAll")
    public List<Module> getAllModules(){
        return null;
    }
    @PostMapping("/create")
    public @ResponseBody Integer createModule(@RequestBody Module module){
        return null;
    }
    @PutMapping("/update")
    public void updateModule(@RequestBody Module module){

    }
    @DeleteMapping("/delete/{id}")
    public void deleteModule(@PathVariable final Integer id){
        
    }
}
