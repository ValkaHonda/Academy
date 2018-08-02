package academy.areas.lessons.services;

import academy.areas.lessons.entities.Lesson;
import academy.areas.lessons.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServicesImpl implements LessonServices{
    private LessonRepository lessonRepository;

    @Autowired
    public LessonServicesImpl(final LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public List<Lesson> getAllLessons() {
        return this.lessonRepository.findAllByActiveTrue();
    }

    @Override
    public Lesson getLesson(Integer id) {
        return this.lessonRepository.findLessonByIdAndActiveTrue(id);
    }

    @Override
    public Integer createLesson(Lesson lesson) {
        if (lesson != null){
            this.lessonRepository.saveAndFlush(lesson);
            return lesson.getId();
        }
        return null;
    }

    private boolean isLessonInRepository(Lesson lesson){
        return lesson != null && this.lessonRepository.findLessonByIdAndActiveTrue(lesson.getId()) != null;
    }

    @Override
    public void updateLesson(Lesson lesson) {
        if (isLessonInRepository(lesson)) {
            this.lessonRepository.saveAndFlush(lesson);
        }
    }

    @Override
    public void disableLesson(Integer id) {
        Lesson lesson = this.lessonRepository.findLessonByIdAndActiveTrue(id);
        if (isLessonInRepository(lesson)){
            lesson.setActive(false);
            this.updateLesson(lesson);
        }
    }
}
