package academy.areas.courses.models.viewModels;

import academy.areas.lessons.entities.Lesson;
import academy.areas.modules.entities.Module;
import academy.areas.modules.models.viewModels.ModuleViewModel;
import academy.areas.users.entities.User;

import java.util.Date;
import java.util.Set;

public class CourseViewModel {
    private Integer id;
    private String name;
    private Date creationDate;
    private Date lastModifiedDate;
    private boolean isActive;

    public CourseViewModel() {
    }

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
