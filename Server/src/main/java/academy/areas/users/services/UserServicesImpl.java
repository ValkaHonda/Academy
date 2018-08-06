package academy.areas.users.services;

import academy.areas.users.entities.Role;
import academy.areas.users.entities.User;
import academy.areas.users.model.bindingModels.UserBindingModel;
import academy.areas.users.models.viewModels.UserViewModel;
import academy.areas.users.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public UserViewModel getUserById(final Integer id) {
        User user = this.userRepository.findOne(id);
        return this.convertToViewModel(user);
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
        this.userRepository.saveAndFlush(user);
        return this.convertToViewModel(user);
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
}
