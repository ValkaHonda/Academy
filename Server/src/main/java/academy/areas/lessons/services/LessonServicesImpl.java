package academy.areas.lessons.services;

import academy.areas.lessons.repositories.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonServicesImpl implements LessonServices{
    private LessonRepository lessonRepository;

    @Autowired
    public LessonServicesImpl(final LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
}
