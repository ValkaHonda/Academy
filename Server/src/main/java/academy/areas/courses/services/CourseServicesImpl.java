package academy.areas.courses.services;

import academy.areas.modules.entities.Module;
import academy.areas.courses.entities.Course;
import academy.areas.courses.models.bindingModel.CourseBindingModel;
import academy.areas.courses.models.viewModels.CourseViewModel;
import academy.areas.courses.repositories.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public CourseViewModel getCourseById(final Integer id) {
        Course course = this.courseRepository.findOne(id);
        return this.convertToViewModel(course);
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
