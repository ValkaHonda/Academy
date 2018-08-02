package academy.areas.lessons.entities;

import academy.areas.courses.entities.Course;
import academy.areas.studyingSubject.entities.StudyingSubject;
import academy.areas.teachers.entities.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "lessons")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Lesson extends StudyingSubject {
    private Set<Teacher> teachers;
    private Course course;
    private Date lessonDate;
    private byte[] presentation;
    private byte[] homework;
    private String videoURL;

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
    @JsonIgnoreProperties("lessons")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Column(name="lesson_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(Date lessonDate) {
        this.lessonDate = lessonDate;
    }

    @Column(name = "presentation")
    public byte[] getPresentation() {
        return presentation;
    }

    public void setPresentation(byte[] presentation) {
        this.presentation = presentation;
    }

    @Column(name = "homework")
    public byte[] getHomework() {
        return homework;
    }

    public void setHomework(byte[] homework) {
        this.homework = homework;
    }

    @Column(name = "video_url")
    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
