package academy.areas.students.entities;

import academy.areas.courses.entities.Course;
import academy.areas.modules.entities.Module;
import academy.areas.users.entities.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Student extends User {
    private Module module;
    private Set<Course> courses;

    public Student(String userName, String firstName, String lastName, String email, String password, Date createDate, Date lastModifiedDate) {
        super(userName, firstName, lastName, email, password, createDate, lastModifiedDate);
    }

    public Student() {
    }

    @Transient
    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Transient
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
