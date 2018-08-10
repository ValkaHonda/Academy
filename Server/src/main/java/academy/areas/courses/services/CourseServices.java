package academy.areas.courses.services;

import academy.areas.courses.entities.Course;
import academy.areas.courses.models.bindingModel.CourseBindingModel;
import academy.areas.courses.models.viewModels.CourseViewModel;
import academy.areas.modules.entities.Module;
import academy.areas.users.entities.User;


import java.util.List;
import java.util.Set;

public interface CourseServices {
    List<CourseViewModel> getAllCourses();
    List<CourseViewModel> getCoursesByUsers(final Set<User> users);
    CourseViewModel getCourseById(final Integer id);
    Course getCourseEntityById(final Integer id);
    CourseViewModel createCourse(final CourseBindingModel courseBindingModel, Module module);
    CourseViewModel updateCourse(final CourseBindingModel courseBindingModel);
    Boolean exists(final String courseName, final String moduleName);

}
