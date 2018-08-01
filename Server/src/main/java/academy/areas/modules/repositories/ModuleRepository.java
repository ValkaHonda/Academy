package academy.areas.modules.repositories;

import academy.areas.modules.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module,Integer> {
}
