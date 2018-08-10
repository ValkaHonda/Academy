package academy.areas.modules.repositories;

import academy.areas.modules.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module,Integer> {
    Module findModuleByName(String moduleName);
}
