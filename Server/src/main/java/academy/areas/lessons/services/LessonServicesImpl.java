package academy.areas.lessons.services;

import academy.areas.courses.entities.Course;
import academy.areas.lessons.entities.Lesson;
import academy.areas.lessons.models.bindingModels.LessonBindingModel;
import academy.areas.lessons.models.viewModels.LessonViewModel;
import academy.areas.lessons.repositories.LessonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Lesson> lessonEntities = this.lessonRepository.findAll();
        return this.convertToViewModelList(lessonEntities);
    }

    @Override
    public LessonViewModel getLessonById(Integer id) {
        Lesson lessonEntity = this.lessonRepository.findOne(id);
        return this.convertToViewModel(lessonEntity);
    }

    @Override
    public LessonViewModel createLesson(LessonBindingModel lessonBindingModel, Course course) {
        Lesson lesson = new Lesson(course);
        lesson = this.transferDataToEntity(lesson,lessonBindingModel);
        this.lessonRepository.saveAndFlush(lesson);
        return this.convertToViewModel(lesson);
    }

    @Override
    public LessonViewModel updateCourse(LessonBindingModel lessonBindingModel) {
        Lesson lesson = this.lessonRepository.findOne(lessonBindingModel.getId());
        lesson = this.transferDataToEntity(lesson,lessonBindingModel);
        this.lessonRepository.saveAndFlush(lesson);
        return this.convertToViewModel(lesson);
    }

    private LessonViewModel convertToViewModel(Lesson lesson){
        return this.modelMapper.map(lesson,LessonViewModel.class);
    }
    private List<LessonViewModel> convertToViewModelList(List<Lesson> lessons) {
        List<LessonViewModel> lessonViewModels = new ArrayList<>();
        for (Lesson lesson : lessons) {
            LessonViewModel currentModel = this.convertToViewModel(lesson);
            lessonViewModels.add(currentModel);
        }
        return lessonViewModels;
    }
    private Lesson transferDataToEntity(Lesson lesson, LessonBindingModel lessonBindingModel){
        return modelMapper.map(lessonBindingModel,Lesson.class);
    }
}
