package academy.areas.lessons.entities;

import academy.areas.courses.entities.Course;
import academy.areas.studyingSubject.entities.StudyingSubject;
import academy.areas.teachers.entities.Teacher;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "lessons")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Lesson extends StudyingSubject {
    private Set<Teacher> teachers;
    private Course course;
//    private Date lesson_date;
//    private String videoURL;
//    private String presentation;
//    private String homework;

    public Lesson(String name, Date creationDate, Date lastModifiedDate, boolean isActive) {
        super(name, creationDate, lastModifiedDate, isActive);
    }

    public Lesson() { }

    @ManyToMany(mappedBy = "lessons")
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @ManyToOne()
    @JoinColumn(name = "courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
