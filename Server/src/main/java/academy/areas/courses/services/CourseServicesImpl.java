package academy.areas.courses.services;

import academy.areas.modules.entities.Module;
import academy.areas.courses.entities.Course;
import academy.areas.courses.models.bindingModel.CourseBindingModel;
import academy.areas.courses.models.viewModels.CourseViewModel;
import academy.areas.courses.repositories.CourseRepository;
import academy.areas.users.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class CourseServicesImpl implements CourseServices {
    private ModelMapper modelMapper;
    private CourseRepository courseRepository;

    @Autowired
    public CourseServicesImpl(final ModelMapper modelMapper,final CourseRepository courseRepository) {
        this.modelMapper = modelMapper;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseViewModel> getAllCourses() {
        List<Course> coursesEntities = this.courseRepository.findAll();
        return this.convertToViewModelList(coursesEntities);
    }

    @Override
    public List<CourseViewModel> getCoursesByUsers(Set<User> users) {
        return this.convertToViewModelList(this.courseRepository.findCourseByUsers(users));
    }

    @Override
    public CourseViewModel getCourseById(final Integer id) {
        Course course = this.courseRepository.findOne(id);
        return this.convertToViewModel(course);
    }

    @Override
    public Course getCourseEntityById(Integer id) {
        return this.courseRepository.findOne(id);
    }

    @Override
    public CourseViewModel createCourse(CourseBindingModel courseBindingModel, Module module) {
        Course course = this.modelMapper.map(courseBindingModel,Course.class);
        course.setModule(module);
        course.setCreationDate(new Date());
        course.setLastModifiedDate(new Date());
        course.setActive(true);
        this.courseRepository.saveAndFlush(course);
        return this.convertToViewModel(course);
    }

    @Override
    public CourseViewModel updateCourse(CourseBindingModel courseBindingModel) {
        Course course = this.courseRepository.findOne(courseBindingModel.getId());
        if (course != null){
            course = this.transferDataToEntity(course,courseBindingModel);
            this.courseRepository.saveAndFlush(course);
            return this.modelMapper.map(course,CourseViewModel.class);
        }
        return null;
    }

    @Override
    public Boolean exists(final String courseName, final String moduleName) {
        Course course = this.courseRepository.findCourseByName(courseName);
        if (course != null){
            return course.getModule().getName().equals(moduleName);
        }
        return false;
    }

    private CourseViewModel convertToViewModel(Course course){
        return this.modelMapper.map(course,CourseViewModel.class);
    }
    private List<CourseViewModel> convertToViewModelList(List<Course> courses) {
        List<CourseViewModel> courseViewModels = new ArrayList<>();
        for (Course course : courses) {
            CourseViewModel currentModel = this.convertToViewModel(course);
            courseViewModels.add(currentModel);
        }
        return courseViewModels;
    }
    private Course transferDataToEntity(Course course, CourseBindingModel courseBindingModel){
        course.setName(courseBindingModel.getName());
        return course;
    }
}
