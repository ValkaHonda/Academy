package academy.areas.courses.services;

import academy.areas.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServicesImpl implements  CourseServices {
    private CourseRepository courseRepository;

    @Autowired
    public CourseServicesImpl(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
}
