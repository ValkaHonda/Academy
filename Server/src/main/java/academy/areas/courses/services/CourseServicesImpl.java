package academy.areas.courses.services;

import academy.areas.courses.entities.Course;
import academy.areas.courses.repositories.CourseRepository;
import academy.areas.lessons.entities.Lesson;
import academy.areas.lessons.services.LessonServices;
import academy.areas.teachers.entities.Teacher;
import academy.areas.teachers.repositories.TeacherRepository;
import academy.areas.teachers.services.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServicesImpl implements  CourseServices {
    private CourseRepository courseRepository;
    private TeacherServices teacherServices;
    private LessonServices lessonServices;

    @Autowired
    public CourseServicesImpl(final CourseRepository courseRepository,
                              final TeacherServices teacherServices,
                              final LessonServices lessonServices) {
        this.courseRepository = courseRepository;
        this.teacherServices = teacherServices;
        this.lessonServices = lessonServices;
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

    @Override
    public void assignTeacherToCourse(Integer teacherId, Integer courseId) {
        Course course = this.getCourse(courseId);
        Teacher teacher = this.teacherServices.getTeacherById(teacherId);
        if (course != null && teacher != null) {
            teacher.addCourse(course);
            this.teacherServices.updateTeacher(teacher);
        }
    }

    @Override
    public void removeTeacherFromCourse(Integer teacherId, Integer courseId) {
        Course course = this.getCourse(courseId);
        Teacher teacher = this.teacherServices.getTeacherById(teacherId);
        if (course != null && teacher != null) {
            teacher.removeCourse(course);
            this.teacherServices.updateTeacher(teacher);
        }
    }

    @Override
    public void addLessonToCourse(Integer lessonId, Integer courseId) {
        Lesson lesson = this.lessonServices.getLesson(lessonId);
        Course course = this.courseRepository.findCourseByIdAndActiveTrue(courseId);
        if(lesson != null && course != null){
            lesson.setCourse(course);
            this.lessonServices.updateLesson(lesson);
        }
    }

    @Override
    public void removeLessonFromCourse(Integer lessonId, Integer courseId) {
        Lesson lesson = this.lessonServices.getLesson(lessonId);
        Course course = this.courseRepository.findCourseByIdAndActiveTrue(courseId);
        if(lesson != null && course != null){
            lesson.setCourse(null);
            this.lessonServices.updateLesson(lesson);
        }
    }
}