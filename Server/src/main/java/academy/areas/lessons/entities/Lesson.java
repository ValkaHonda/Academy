package academy.areas.lessons.entities;

import academy.areas.courses.entities.Course;
import academy.areas.studyingSubject.entities.StudyingSubject;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "lessons")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Lesson extends StudyingSubject {
//    private Course course;
//    private Date lesson_date;
//    private String videoURL;
//    private String presentation;
//    private String homework;

    public Lesson(String name, Date creationDate, Date lastModifiedDate, boolean isActive) {
        super(name, creationDate, lastModifiedDate, isActive);
    }

    public Lesson() { }

}
