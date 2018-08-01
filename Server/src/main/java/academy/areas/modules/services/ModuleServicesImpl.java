package academy.areas.modules.services;

import academy.areas.modules.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModuleServicesImpl implements ModuleServices {
    private ModuleRepository moduleRepository;

    @Autowired
    public ModuleServicesImpl(final ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }
}
