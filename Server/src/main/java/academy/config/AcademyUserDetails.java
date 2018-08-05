package academy.config;


import academy.areas.users.entities.Role;
import academy.areas.users.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

public class AcademyUserDetails extends User implements UserDetails{
    private User user;
    private List<Role> roles; // It was done with Array list in the example

    public AcademyUserDetails(User user, List<Role> roles) {
        super(user.getUserName(),user.getFirstName(),user.getPassword());
        this.user = user;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String userRoles = StringUtils.collectionToCommaDelimitedString(this.roles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(userRoles);
    }

    @Override
    public String getUsername() {
        return this.user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public User getUser(){
        return this.user;
    }
}
