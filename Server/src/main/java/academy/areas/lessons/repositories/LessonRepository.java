package academy.areas.lessons.repositories;

import academy.areas.lessons.entities.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Integer> {
}
