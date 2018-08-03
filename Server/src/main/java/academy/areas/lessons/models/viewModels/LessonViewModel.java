package academy.areas.lessons.models.viewModels;

import academy.areas.courses.entities.Course;

import java.util.Date;

public class LessonViewModel {
    private Course course;
    private Date lessonDate;
    private byte[] presentation;
    private byte[] homework;
    private String videoURL;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(Date lessonDate) {
        this.lessonDate = lessonDate;
    }

    public byte[] getPresentation() {
        return presentation;
    }

    public void setPresentation(byte[] presentation) {
        this.presentation = presentation;
    }

    public byte[] getHomework() {
        return homework;
    }

    public void setHomework(byte[] homework) {
        this.homework = homework;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
