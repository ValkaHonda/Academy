package academy.services;

import academy.areas.exceptions.UserNotFoundException;
import academy.areas.users.entities.User;
import academy.areas.users.repositories.RoleRepository;
import academy.areas.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUserName(username);
        if(user == null){
            throw new UserNotFoundException("User not found");
        }

        return user;
    }
}

