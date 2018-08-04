package academy.areas.lessons.services;

import academy.areas.courses.entities.Course;
import academy.areas.lessons.entities.Lesson;
import academy.areas.lessons.models.bindingModels.LessonBindingModel;
import academy.areas.lessons.models.viewModels.LessonViewModel;

import java.util.List;

public interface LessonServices {
    List<LessonViewModel> getAllLessons();
    LessonViewModel getLessonById(final Integer id);
    LessonViewModel createLesson(final LessonBindingModel lessonBindingModel, Course course);
    LessonViewModel updateCourse(final LessonBindingModel lessonBindingModel);
}
