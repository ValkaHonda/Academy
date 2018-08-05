package academy.areas.users.services;

import academy.areas.users.entities.Role;
import academy.areas.users.model.bindingModels.UserBindingModel;
import academy.areas.users.models.viewModels.UserViewModel;

import java.util.List;

public interface UserServices {
    UserViewModel getUserById(final Integer id);
    List<UserViewModel> getAllUsers();
    UserViewModel registerUser(final UserBindingModel userBindingModel, final Role role);
}
