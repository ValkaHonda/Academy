package academy.areas.modules.controllers;

import academy.areas.modules.services.ModuleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/module")
public class ModuleRestController {
    private ModuleServices moduleServices;

    @Autowired
    public ModuleRestController(ModuleServices moduleServices) {
        this.moduleServices = moduleServices;
    }
}
