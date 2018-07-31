package academy.areas.admins.entities;

import academy.areas.courses.entities.Course;
import academy.areas.modules.entities.Module;
import academy.areas.users.entities.User;

import javax.persistence.*;
import java.beans.Transient;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "admins")
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Admin extends User {
   // private Set<Module> modules;
//    private Set<Course> courses;

    public Admin(String userName, String firstName, String lastName, String email, String password, Date createDate, Date lastModifiedDate) {
        super(userName, firstName, lastName, email, password, createDate, lastModifiedDate);
    }

    public Admin() {
    }


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "admins_modules")
//    public Set<Module> getModules() {
//        return modules;
//    }
//
//    public void setModules(Set<Module> modules) {
//        this.modules = modules;
//    }

//
//    @Transient
//    public Set<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Set<Course> courses) {
//        this.courses = courses;
//    }
}
