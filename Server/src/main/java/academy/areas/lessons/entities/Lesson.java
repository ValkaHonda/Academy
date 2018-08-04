package academy.areas.lessons.entities;

import academy.areas.courses.entities.Course;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "lessons")
public class Lesson {
    private Integer id;
    private String name;
    private Date creationDate;
    private Date lastModifiedDate;
    private boolean isActive;
    private Course course;
    private Date lessonDate;
    private byte[] presentation;
    private byte[] homework;
    private String videoURL;

    public Lesson() { }

    public Lesson(Course course) {
        this.course = course;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name="last_modified_at")
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Column(name = "active")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
