package academy.areas.users.services;

import academy.areas.courses.entities.Course;
import academy.areas.users.entities.Role;
import academy.areas.users.entities.User;
import academy.areas.users.model.bindingModels.UserBindingModel;
import academy.areas.users.model.bindingModels.UserUpdateBindingModel;
import academy.areas.users.models.viewModels.UserViewModel;
import academy.areas.users.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServicesImpl implements UserServices {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServicesImpl(final BCryptPasswordEncoder bCryptPasswordEncoder, final UserRepository userRepository,
                            final ModelMapper modelMapper) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserViewModel getUserByUserName(String username) {
        User user = this.userRepository.findUserByUserName(username);
        if (user != null){
            return this.convertToViewModel(user);
        }
        return null;
    }

    @Override
    public UserViewModel getUserById(final Integer id) {
        User user = this.userRepository.findOne(id);
        return this.convertToViewModel(user);
    }

    @Override
    public User getUserEntityById(Integer id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public List<UserViewModel> getAllUsers() {
        List<User> userEntities = this.userRepository.findAll();
        return this.convertToViewModelList(userEntities);
    }

    @Override
    public UserViewModel registerUser(UserBindingModel userBindingModel, Role role) {
        userBindingModel.setPassword(this.bCryptPasswordEncoder.encode(userBindingModel.getPassword()));
        User user = this.transferDataToEntity(userBindingModel);
        user.setRoles(new HashSet<>());
        user.setActive(true);
        user.getRoles().add(role);
        user.setCreateDate(new Date());
        user.setLastModifiedDate(new Date());
        this.userRepository.saveAndFlush(user);
        return this.convertToViewModel(user);
    }

    @Override
    public UserViewModel updateUser(UserUpdateBindingModel userUpdateBindingModel) {
        User user = this.userRepository.findOne(userUpdateBindingModel.getId());
        if (user != null){
            user = this.transferDataToEntity(user,userUpdateBindingModel);
            user.setLastModifiedDate(new Date());
            this.userRepository.saveAndFlush(user);
            return this.convertToViewModel(user);
        }
        return null;
    }

    @Override
    public UserViewModel assignStudentToCourse(final User user, final Course course) {
        if (user != null && course != null){
            if (user.getCourses() == null){
                user.setCourses(new HashSet<>());
            }
            user.getCourses().add(course);
            this.userRepository.saveAndFlush(user);
            return this.convertToViewModel(user);
        }
        return null;
    }

    private UserViewModel convertToViewModel(User user){
        return this.modelMapper.map(user,UserViewModel.class);
    }
    private List<UserViewModel> convertToViewModelList(List<User> users) {
        List<UserViewModel> userViewModels = new ArrayList<>();
        for (User user : users) {
            UserViewModel currentModel = this.convertToViewModel(user);
            userViewModels.add(currentModel);
        }
        return userViewModels;
    }
    private User transferDataToEntity(UserBindingModel userBindingModel){
        return modelMapper.map(userBindingModel,User.class);
    }

    private User transferDataToEntity(User user, UserUpdateBindingModel userBindingModel){
        user.setFirstName(userBindingModel.getFirstName());
        user.setLastName(userBindingModel.getLastName());
        user.setEmail(userBindingModel.getEmail());
        return user;
    }
}
