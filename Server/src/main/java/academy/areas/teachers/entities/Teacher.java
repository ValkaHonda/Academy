package academy.areas.teachers.entities;

import academy.areas.courses.entities.Course;
import academy.areas.lessons.entities.Lesson;
import academy.areas.users.entities.User;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Teacher extends User {
    private Set<Course> courses;
    private Set<Lesson> lessons;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teachers_courses")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "teachers_lessons")
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
