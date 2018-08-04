package academy.areas.lessons.controllers;

import academy.areas.lessons.services.LessonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson")
public class LessonRestController {
    private LessonServices lessonServices;

    @Autowired
    public LessonRestController(LessonServices lessonServices) {
        this.lessonServices = lessonServices;
    }
}
