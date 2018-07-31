package academy.areas.users.entities;

import java.util.Date;

public abstract class User {
    private Integer id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date createDate;
    private Date lastModifiedDate;
}
