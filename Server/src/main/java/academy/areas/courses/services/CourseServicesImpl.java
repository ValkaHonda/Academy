package academy.areas.courses.services;

import academy.areas.courses.entities.Course;
import academy.areas.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServicesImpl implements  CourseServices {
    private CourseRepository courseRepository;

    @Autowired
    public CourseServicesImpl(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return this.courseRepository.findAllByActiveTrue();
    }

    @Override
    public Course getCourse(final Integer id) {
        return this.courseRepository.findCourseByIdAndActiveTrue(id);
    }

    @Override
    public Integer createCourse(Course course) {
        if (course != null){
            this.courseRepository.saveAndFlush(course);
            return course.getId();
        }
        return null;
    }

    @Override
    public void updateCourse(Course course) {
        if (isInCourseRepository(course)){
            this.courseRepository.saveAndFlush(course);
        }
    }
    private boolean isInCourseRepository(Course course){
        return course != null && this.courseRepository
                .findCourseByIdAndActiveTrue(course.getId()) != null;

    }

    @Override
    public void disableCourse(final Integer id) {
        Course course = this.courseRepository.findCourseByIdAndActiveTrue(id);
        if (isInCourseRepository(course)){
            course.setActive(false);
            this.courseRepository.saveAndFlush(course);
        }
    }
}
