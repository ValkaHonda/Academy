package academy.areas.admins.services;

import academy.areas.admins.entities.Admin;
import academy.areas.admins.repositories.AdminRepository;
import academy.areas.teachers.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServicesImpl implements AdminServices{
    private AdminRepository adminRepository;

    @Autowired
    public AdminServicesImpl(final AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return this.adminRepository.findAllByActiveTrue();
    }

    @Override
    public Admin getById(final Integer id) {
        return this.adminRepository.findAdminByIdAndActiveTrue(id);
    }

    @Override
    public Integer createAdmin(final Admin admin) {
        if (admin != null){
            this.adminRepository.saveAndFlush(admin);
            return admin.getId();
        }
        return null;
    }

    @Override
    public void updateAdmin(final Admin admin) {
        if (this.adminRepository
                .findAdminByIdAndActiveTrue(admin.getId()) != null){
            this.adminRepository.saveAndFlush(admin);
        }
    }

    @Override
    public void disableAdmin(final Integer id) {
        Admin admin = this.adminRepository.findAdminByIdAndActiveTrue(id);
        if (admin != null){
            admin.setActive(false);
            this.adminRepository.saveAndFlush(admin);
        }
    }
}
