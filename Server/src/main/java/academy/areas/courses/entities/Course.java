package academy.areas.courses.entities;

import academy.areas.studingSubject.entities.StudingSubject;
import academy.areas.teachers.entities.Teacher;

import java.util.Date;
import java.util.Set;

public class Course extends StudingSubject {
    private Teacher teacher;
    private Set<Course> courses;
}
