package academy.areas.courses.services;

import academy.areas.courses.entities.Course;


import java.util.List;

public interface CourseServices {
    List<Course> getAllCourses();
    Integer createCourse(Course course);
    void updateCourse(Course course);
    void disableCourse(final Integer id);
    void assignTeacherToCourse(final Integer teacherId, final Integer courseId);
    void removeTeacherFromCourse(final Integer teacherId, final Integer courseId);
    void addLessonToCourse(final Integer lessonId, final Integer courseId);
    void removeLessonFromCourse(final Integer lessonId, final Integer courseId);
}
