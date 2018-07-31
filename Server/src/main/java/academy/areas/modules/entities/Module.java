package academy.areas.modules.entities;

import academy.areas.admins.entities.Admin;
import academy.areas.courses.entities.Course;
import academy.areas.students.entities.Student;
import academy.areas.studingSubject.entities.StudingSubject;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

public class Module extends StudingSubject {
    private Set<Admin> admins;
    private Set<Course> courses;
    private Set<Student> students;
}
