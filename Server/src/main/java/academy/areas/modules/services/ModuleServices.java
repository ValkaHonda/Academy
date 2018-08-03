package academy.areas.modules.services;

import academy.areas.courses.entities.Course;
import academy.areas.modules.entities.Module;
import academy.areas.modules.models.viewModels.ModuleViewModel;

import java.util.List;

public interface ModuleServices {
    List<ModuleViewModel> getAllModules();
    ModuleViewModel getModuleById(final Integer id);
    ModuleViewModel createModule(final Module module);
    void updateModule(final Module module);
}
