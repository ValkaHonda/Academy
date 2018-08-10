package academy.areas.lessons.repositories;

import academy.areas.courses.entities.Course;
import academy.areas.lessons.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {
    List<Lesson> findLessonByCourse(final Course course);
}

