package academy.areas.users.services;

import academy.areas.courses.entities.Course;
import academy.areas.users.entities.Role;
import academy.areas.users.entities.User;
import academy.areas.users.model.bindingModels.UserBindingModel;
import academy.areas.users.model.bindingModels.UserUpdateBindingModel;
import academy.areas.users.models.viewModels.UserViewModel;

import java.util.List;

public interface UserServices {
    UserViewModel getUserById(final Integer id);
    User getUserEntityById(final Integer id);
    List<UserViewModel> getAllUsers();
    UserViewModel registerUser(final UserBindingModel userBindingModel, final Role role);
    UserViewModel updateUser(final UserUpdateBindingModel userUpdateBindingModel);
    UserViewModel assignStudentToCourse(final User user, final Course course);
}
