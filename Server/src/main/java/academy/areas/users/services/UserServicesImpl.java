package academy.areas.users.services;

import academy.areas.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;

    @Autowired
    public UserServicesImpl(final BCryptPasswordEncoder bCryptPasswordEncoder, final UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }
}
