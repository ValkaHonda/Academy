package academy.areas.lessons.controllers;

import academy.areas.courses.entities.Course;
import academy.areas.courses.repositories.CourseRepository;
import academy.areas.courses.services.CourseServices;
import academy.areas.lessons.models.bindingModels.LessonBindingModel;
import academy.areas.lessons.models.viewModels.LessonViewModel;
import academy.areas.lessons.services.LessonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
public class LessonRestController {
    private LessonServices lessonServices;
    private CourseServices courseServices;

    @Autowired
    public LessonRestController(final LessonServices lessonServices, final CourseServices courseServices) {
        this.lessonServices = lessonServices;
        this.courseServices = courseServices;
    }
    @GetMapping("/getById/{id}")
    public LessonViewModel getLessonById(@PathVariable final Integer id){
        return this.lessonServices.getLessonById(id);
    }
    @GetMapping("/getAll")
    public List<LessonViewModel> getLessons(){
        return this.lessonServices.getAllLessons();
    }

    @PostMapping("/create/{courseId}")
    public @ResponseBody  LessonViewModel createLesson(@RequestBody final LessonBindingModel lessonBindingModel,
                                                       @PathVariable final Integer courseId){
        Course course = this.courseServices.getCourseEntityById(courseId);
        if (course != null){
            return this.lessonServices.createLesson(lessonBindingModel,course);
        }
        return null;
    }
    @PutMapping("/update")
    public @ResponseBody LessonViewModel updateLesson(@RequestBody LessonBindingModel lessonBindingModel){
        return this.lessonServices.updateCourse(lessonBindingModel);
    }
}
