package academy.areas.teachers.entities;

import academy.areas.courses.entities.Course;
import academy.areas.users.entities.User;

import java.util.Set;

public class Teacher extends User {
    private Set<Course> courses;
    private Set<Teacher> teachers;
}
