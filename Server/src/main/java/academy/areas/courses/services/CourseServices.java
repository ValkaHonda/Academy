package academy.areas.courses.services;

import academy.areas.courses.entities.Course;

import java.util.List;

public interface CourseServices {
    List<Course> getAllCourses();
    Course getCourse(final Integer id);
    Integer createCourse(Course course);
    void updateCourse(Course course);
    void disableCourse(final Integer id);
}
