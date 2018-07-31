package academy.areas.studyingSubject.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "studying_subjects")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class StudyingSubject {
    private Integer id;
    private String name;
    private Date creationDate;
    private Date lastModifiedDate;
    private boolean isActive;

    public StudyingSubject(String name, Date creationDate, Date lastModifiedDate, boolean isActive) {
        this.name = name;
        this.creationDate = creationDate;
        this.lastModifiedDate = lastModifiedDate;
        this.isActive = isActive;
    }

    public StudyingSubject() { }

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
}
