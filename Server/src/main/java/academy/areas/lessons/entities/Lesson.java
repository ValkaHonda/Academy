package academy.areas.lessons.entities;

import academy.areas.courses.entities.Course;
import academy.areas.studyingSubject.entities.StudyingSubject;

import java.util.Date;

public class Lesson extends StudyingSubject {
    private Course course;
    private Date lesson_date;
    private String videoURL;
    private String presentation;
    private String homework;
}
