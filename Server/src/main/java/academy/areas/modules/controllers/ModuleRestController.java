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
        return this.moduleServices.getModule(id);
    }
    @GetMapping("/getAll")
    public List<Module> getAllModules(){
        return this.moduleServices.getAllModules();
    }
    @PostMapping("/create")
    public @ResponseBody Integer createModule(@RequestBody Module module){
        return this.moduleServices.createModule(module);
    }
    @PutMapping("/update")
    public void updateModule(@RequestBody Module module){
        this.moduleServices.updateModule(module);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteModule(@PathVariable final Integer id){
        this.moduleServices.disableModule(id);
    }
}
