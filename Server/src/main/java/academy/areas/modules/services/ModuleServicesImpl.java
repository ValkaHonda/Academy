package academy.areas.modules.services;

import academy.areas.modules.entities.Module;
import academy.areas.modules.models.bidingModel.ModuleBindingModel;
import academy.areas.modules.models.viewModels.ModuleViewModel;
import academy.areas.modules.repositories.ModuleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ModuleServicesImpl implements ModuleServices{
    private ModuleRepository moduleRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ModuleServicesImpl(ModuleRepository moduleRepository, ModelMapper modelMapper) {
        this.moduleRepository = moduleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ModuleViewModel> getAllModules() {
        return this.convertModulesListToViewModelsList(this.moduleRepository.findAll());
    }

    @Override
    public ModuleViewModel getModuleById(final Integer id) {
        return this.convertModuleToViewModel(this.moduleRepository.findOne(id));
    }

    @Override
    public Module getModuleEntityById(Integer id) {
        return this.moduleRepository.findOne(id);
    }

    @Override
    public ModuleViewModel createModule(final ModuleBindingModel moduleBindingModel) {
        if (moduleBindingModel != null){
            Module module = this.modelMapper.map(moduleBindingModel,Module.class);
            module.setActive(true);
            module.setCreationDate(new Date());
            module.setLastModifiedDate(new Date());
            this.moduleRepository.saveAndFlush(module);
            return this.convertModuleToViewModel(module);
        }
        return null;
    }

    @Override
    public ModuleViewModel updateModule(final ModuleBindingModel moduleBindingModel) {
        if (this.moduleRepository.exists(moduleBindingModel.getId())){
            Module module = this.modelMapper.map(moduleBindingModel,Module.class);
            module.setLastModifiedDate(new Date());
            this.moduleRepository.saveAndFlush(module);
            return this.convertModuleToViewModel(module);
        }
        return null;
    }

    @Override
    public boolean exists(final Integer id) {
        return this.moduleRepository.exists(id);
    }

    @Override
    public boolean exists(String moduleName) {
        Module module = this.moduleRepository.findModuleByName(moduleName);
        return module!=null;
    }

    private ModuleViewModel convertModuleToViewModel(final Module module) {
        return this.modelMapper.map(module,ModuleViewModel.class);
    }

    private List<ModuleViewModel> convertModulesListToViewModelsList(final List<Module> modules) {
        List<ModuleViewModel> moduleViewModels = new ArrayList<>();
        for (Module module : modules) {
            ModuleViewModel currentModel = this.convertModuleToViewModel(module);
            moduleViewModels.add(currentModel);
        }
        return moduleViewModels;
    }
}
