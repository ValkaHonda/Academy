package academy.areas.students.entities;

import academy.areas.courses.entities.Course;
import academy.areas.users.entities.User;

import java.util.Set;

public class Student extends User {
    private Set<Course> courses;
}
