package academy.areas.courses.entities;

import academy.areas.lessons.entities.Lesson;
import academy.areas.modules.entities.Module;
import academy.areas.studyingSubject.entities.StudyingSubject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Course extends StudyingSubject {
    private Integer id;
    private String name;
    private Date creationDate;
    private Date lastModifiedDate;
    private boolean isActive;

















    private Module module;
    private Set<Lesson> lessons;


    public Course(String name, Date creationDate, Date lastModifiedDate, boolean isActive) {
        super(name, creationDate, lastModifiedDate, isActive);

    }

    public Course() { }

    @ManyToOne()
    @JoinColumn(name = "moduleId")
    @JsonIgnoreProperties("courses")
    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties("courses")
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }
}
