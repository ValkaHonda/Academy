package academy.areas.courses.entities;

import academy.areas.admins.entities.Admin;
import academy.areas.lessons.entities.Lesson;
import academy.areas.modules.entities.Module;
import academy.areas.students.entities.Student;
import academy.areas.studyingSubject.entities.StudyingSubject;
import academy.areas.teachers.entities.Teacher;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "courses")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Course extends StudyingSubject {
    private Set<Teacher> teachers;
    private Set<Admin> admins;
//    private Module module;
//    private Set<Lesson> lessons;
      private Set<Student> students;

    public Course(String name, Date creationDate, Date lastModifiedDate, boolean isActive) {
        super(name, creationDate, lastModifiedDate, isActive);
    }

    public Course() { }


    @ManyToMany(mappedBy = "courses")
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @ManyToMany(mappedBy = "courses")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @ManyToMany(mappedBy = "courses")
    public Set<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }
}
