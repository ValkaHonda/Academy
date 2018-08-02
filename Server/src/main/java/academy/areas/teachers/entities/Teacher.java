package academy.areas.teachers.entities;

import academy.areas.courses.entities.Course;
import academy.areas.lessons.entities.Lesson;
import academy.areas.users.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Teacher extends User {
    private Set<Course> courses;

    public Teacher(
            String userName,
            String firstName,
            String lastName,
            String email,
            String password,
            Date createDate,
            Date lastModifiedDate,
            boolean isActive) {
        super(userName, firstName, lastName, email, password, createDate, lastModifiedDate,isActive);
        this.courses = new HashSet<>();
    }

    public Teacher() { }

    public void addCourse(Course course){
        this.courses.add(course);
    }
    public void removeCourse(Course course){
        this.courses.remove(course);
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teachers_courses")
    @JsonIgnoreProperties("teachers")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
