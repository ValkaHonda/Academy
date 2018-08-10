package academy.areas.modules.controllers;

import academy.areas.modules.models.bidingModel.ModuleBindingModel;
import academy.areas.modules.models.viewModels.ModuleViewModel;
import academy.areas.modules.services.ModuleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/module")
public class ModuleRestController {
    private ModuleServices moduleServices;

    @Autowired
    public ModuleRestController(ModuleServices moduleServices) {
        this.moduleServices = moduleServices;
    }

    @GetMapping("/getById/{id}")
    public ModuleViewModel getModule(@PathVariable final Integer id){
        return this.moduleServices.getModuleById(id);
    }
    @GetMapping("/getAll")
    public List<ModuleViewModel> getModules(){
        return this.moduleServices.getAllModules();
    }
    @PostMapping("/create")
    public @ResponseBody  ModuleViewModel createModule(@RequestBody ModuleBindingModel moduleBindingModel){
        return this.moduleServices.createModule(moduleBindingModel);
    }
    @PutMapping("/update")
    public @ResponseBody ModuleViewModel updateModule(@RequestBody ModuleBindingModel moduleBindingModel){
        return this.moduleServices.updateModule(moduleBindingModel);
    }
}
