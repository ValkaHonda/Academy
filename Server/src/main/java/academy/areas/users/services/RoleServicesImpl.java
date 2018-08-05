package academy.areas.users.services;

import academy.areas.users.entities.Role;
import academy.areas.users.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServicesImpl implements RoleServices{
    private RoleRepository roleRepository;

    @Autowired
    public RoleServicesImpl(final RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String roleName) {
        return this.roleRepository.findRoleByName(roleName);
    }
}
