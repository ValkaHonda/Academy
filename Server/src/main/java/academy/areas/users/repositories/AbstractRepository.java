package academy.areas.users.repositories;

import academy.areas.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbstractRepository <U extends User> extends JpaRepository<U,Integer> {
    List<U> findAllByActiveTrue();
}
