package academy.areas.admins.entities;

import academy.areas.modules.entities.Module;
import academy.areas.users.entities.User;

import java.util.Set;

public class Admin extends User {
    private Set<Module> modules;
}
