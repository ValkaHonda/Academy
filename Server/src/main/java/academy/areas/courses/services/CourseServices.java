package academy.areas.courses.services;

import academy.areas.courses.entities.Course;
import academy.areas.courses.models.bindingModel.CourseBindingModel;
import academy.areas.courses.models.viewModels.CourseViewModel;
import academy.areas.modules.entities.Module;


import java.util.List;

public interface CourseServices {
    List<CourseViewModel> getAllCourses();
    CourseViewModel getCourseById(final Integer id);
    Course getCourseEntityById(final Integer id);
    CourseViewModel createCourse(final CourseBindingModel courseBindingModel, Module module);
    CourseViewModel updateCourse(final CourseBindingModel courseBindingModel);
    Boolean exists(final String courseName, final String moduleName);
}
