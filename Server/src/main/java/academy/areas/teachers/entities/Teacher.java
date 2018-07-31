package academy.areas.teachers.entities;

import academy.areas.courses.entities.Course;
import academy.areas.users.entities.User;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Teacher extends User {
    private Set<Course> courses;
    private Set<Teacher> teachers;
    private String someText;

    public Teacher(String userName, String firstName, String lastName, String email, String password, Date createDate, Date lastModifiedDate) {
        super(userName, firstName, lastName, email, password, createDate, lastModifiedDate);
    }

    public Teacher() { }

    @Transient
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @Transient
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Column(name = "some_text")
    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }
}
