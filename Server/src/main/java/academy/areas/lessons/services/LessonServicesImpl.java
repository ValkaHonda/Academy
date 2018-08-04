package academy.areas.lessons.services;

import academy.areas.courses.entities.Course;
import academy.areas.lessons.models.bindingModels.LessonBindingModel;
import academy.areas.lessons.models.viewModels.LessonViewModel;
import academy.areas.lessons.repositories.LessonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServicesImpl implements LessonServices{
    private LessonRepository lessonRepository;
    private ModelMapper modelMapper;

    @Autowired
    public LessonServicesImpl(final LessonRepository lessonRepository,final ModelMapper modelMapper) {
        this.lessonRepository = lessonRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LessonViewModel> getAllLessons() {
        return null;
    }

    @Override
    public LessonViewModel getLessonById(Integer id) {
        return null;
    }

    @Override
    public LessonViewModel createLesson(LessonBindingModel lessonBindingModel, Course course) {
        return null;
    }

    @Override
    public LessonViewModel updateCourse(LessonBindingModel lessonBindingModel) {
        return null;
    }
}
