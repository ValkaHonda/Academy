package academy.areas.modules.services;

import academy.areas.courses.entities.Course;
import academy.areas.modules.entities.Module;
import academy.areas.modules.models.bidingModel.ModuleBindingModel;
import academy.areas.modules.models.viewModels.ModuleViewModel;

import java.util.List;

public interface ModuleServices {
    List<ModuleViewModel> getAllModules();
    ModuleViewModel getModuleById(final Integer id);
    Module getModuleEntityById(final Integer id);
    ModuleViewModel createModule(final ModuleBindingModel moduleBindingModel);
    ModuleViewModel updateModule(final ModuleBindingModel moduleBindingModel);
    boolean exists(final Integer id);
    boolean exists(final String moduleName);
}
