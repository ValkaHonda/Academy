package academy.areas.courses.entities;

import academy.areas.admins.entities.Admin;
import academy.areas.lessons.entities.Lesson;
import academy.areas.modules.entities.Module;
import academy.areas.students.entities.Student;
import academy.areas.studingSubject.entities.StudingSubject;
import academy.areas.teachers.entities.Teacher;

import java.util.Date;
import java.util.Set;

public class Course extends StudingSubject {
    private Set<Teacher> teachers;
    private Set<Admin> admins;
    private Module module;
    private Set<Lesson> lessons;
    private Set<Student> students;
}
