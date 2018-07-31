package academy.areas.courses.entities;

import academy.areas.admins.entities.Admin;
import academy.areas.lessons.entities.Lesson;
import academy.areas.modules.entities.Module;
import academy.areas.students.entities.Student;
import academy.areas.studyingSubject.entities.StudyingSubject;
import academy.areas.teachers.entities.Teacher;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "courses")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Course extends StudyingSubject {
//    private Set<Teacher> teachers;
//    private Set<Admin> admins;
//    private Module module;
//    private Set<Lesson> lessons;
//    private Set<Student> students;
}
