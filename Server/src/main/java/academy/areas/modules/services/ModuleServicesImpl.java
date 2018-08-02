package academy.areas.modules.services;

import academy.areas.modules.entities.Module;
import academy.areas.modules.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServicesImpl implements ModuleServices {
    private ModuleRepository moduleRepository;

    @Autowired
    public ModuleServicesImpl(final ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public List<Module> getAllModules() {
        return this.moduleRepository.findAllByActiveTrue();
    }

    @Override
    public Module getModule(Integer id) {
        return this.moduleRepository.findModuleByIdAndActiveTrue(id);
    }
    private boolean isInModuleRepository(Module module){
        return module != null && this.moduleRepository
                .findModuleByIdAndActiveTrue(module.getId()) != null;
    }

    @Override
    public Integer createModule(Module module) {
        if (module != null){
            this.moduleRepository.saveAndFlush(module);
            return module.getId();
        }
        return null;
    }

    @Override
    public void updateModule(Module module) {
        if (isInModuleRepository(module)){
            this.moduleRepository.saveAndFlush(module);
        }
    }

    @Override
    public void disableModule(Integer id) {
        Module module = this.moduleRepository.findModuleByIdAndActiveTrue(id);
        if (this.isInModuleRepository(module)){
            module.setActive(false);
            this.moduleRepository.saveAndFlush(module);
        }
    }
}
