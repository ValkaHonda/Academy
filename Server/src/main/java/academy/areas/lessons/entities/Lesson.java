package academy.areas.lessons.entities;

import academy.areas.courses.entities.Course;
import academy.areas.studingSubject.entities.StudingSubject;

import java.util.Date;

public class Lesson extends StudingSubject {
    private Course course;
    private Date lesson_date;
    private String videoURL;
    private String presentation;
    private String homework;
}
