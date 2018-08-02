package academy.areas.modules.entities;

import academy.areas.admins.entities.Admin;
import academy.areas.courses.entities.Course;
import academy.areas.students.entities.Student;
import academy.areas.studyingSubject.entities.StudyingSubject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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
        this.courses = new HashSet<>();
    }

    @ManyToMany(mappedBy = "modules")
    public Set<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }

    @OneToMany(mappedBy = "module")
    @JsonIgnoreProperties("modules")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    @OneToMany(mappedBy = "module")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
    public void removeCourse(Course course){
        this.courses.remove(course);
    }
}
