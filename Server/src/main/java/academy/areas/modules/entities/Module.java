package academy.areas.modules.entities;

import academy.areas.admins.entities.Admin;
import academy.areas.studingSubject.entities.StudingSubject;

import javax.persistence.Entity;
import java.util.Date;

public class Module extends StudingSubject {
    private Admin admin;
}
