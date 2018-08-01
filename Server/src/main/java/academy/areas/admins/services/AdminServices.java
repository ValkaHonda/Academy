package academy.areas.admins.services;

import academy.areas.admins.entities.Admin;

import java.util.List;

public interface AdminServices {
    List<Admin> getAllAdmins();
    Admin getById(final Integer id);
    Integer createAdmin(final Admin admin);
    void updateAdmin(final Admin admin);
    void disableAdmin(final Integer id);
}
