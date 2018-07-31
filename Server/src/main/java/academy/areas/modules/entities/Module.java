package academy.areas.modules.entities;

import academy.areas.admins.entities.Admin;
import academy.areas.courses.entities.Course;
import academy.areas.students.entities.Student;
import academy.areas.studyingSubject.entities.StudyingSubject;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "modules")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Module extends StudyingSubject {
    private Set<Admin> admins;
    private Set<Course> courses;
    private Set<Student> students;

    public Module() {
    }

    public Module(String name, Date creationDate, Date lastModifiedDate, boolean isActive) {
        super(name, creationDate, lastModifiedDate, isActive);
    }

    @Transient//@ManyToMany(mappedBy = "modules")
    public Set<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }

    @Transient
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Transient
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
