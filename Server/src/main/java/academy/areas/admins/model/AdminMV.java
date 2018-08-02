package academy.areas.admins.model;


import academy.areas.modules.entities.Module;
import academy.areas.users.model.UserMV;

import java.util.Date;
import java.util.Set;

public class AdminMV extends UserMV{
    private Set<Module> modules;

    public AdminMV() { }

    public AdminMV(Integer id, String userName, String firstName, String lastName, String email, String password, Date createDate, Date lastModifiedDate, boolean isActive, Set<Module> modules) {
        super(id, userName, firstName, lastName, email, password, createDate, lastModifiedDate, isActive);
        this.modules = modules;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }
}
