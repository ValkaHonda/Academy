package academy.areas.lessons.services;

import academy.areas.lessons.entities.Lesson;
import academy.areas.lessons.models.viewModels.LessonViewModel;

import java.util.List;

public interface LessonServices {
    List<Lesson> getAllLessons();
    Lesson getLesson(final Integer id);
    Integer createLesson(Lesson lesson);
    void updateLesson(Lesson lesson);
    void disableLesson(final Integer id);

    LessonViewModel getLessonById(Integer id) throws Exception;
}
