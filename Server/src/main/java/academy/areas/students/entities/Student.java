package academy.areas.students.entities;

import academy.areas.courses.entities.Course;
import academy.areas.modules.entities.Module;
import academy.areas.users.entities.User;

import java.util.Set;

public class Student extends User {
    private Module module;
    private Set<Course> courses;
}
