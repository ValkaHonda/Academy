package academy.areas.courses.services;

import academy.areas.courses.entities.Course;
import academy.areas.courses.model.CourseMV;

import java.util.List;

public interface CourseServices {
    List<Course> getAllCourses();
    CourseMV getCourse(final Integer id);
    Integer createCourse(Course course);
    void updateCourse(Course course);
    void disableCourse(final Integer id);
    void assignTeacherToCourse(final Integer teacherId, final Integer courseId);
    void removeTeacherFromCourse(final Integer teacherId, final Integer courseId);
    void addLessonToCourse(final Integer lessonId, final Integer courseId);
    void removeLessonFromCourse(final Integer lessonId, final Integer courseId);
}
