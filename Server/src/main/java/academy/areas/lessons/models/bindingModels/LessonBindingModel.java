package academy.areas.lessons.models.bindingModels;

import java.util.Date;

public class LessonBindingModel {
    private Integer id;
    private String name;
    private Date lessonDate;
    private byte[] presentation;
    private byte[] homework;
    private String videoURL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
