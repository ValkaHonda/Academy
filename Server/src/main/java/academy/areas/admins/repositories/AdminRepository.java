package academy.areas.admins.repositories;

import academy.areas.admins.entities.Admin;
import academy.areas.teachers.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    List<Admin> findAllByActiveTrue();
    Admin findAdminByIdAndActiveTrue(final Integer Id);
    Admin findAdminByUserName(final String userName);
}
