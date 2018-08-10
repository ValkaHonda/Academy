package academy.areas.courses.repositories;

import academy.areas.courses.entities.Course;
import academy.areas.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course findCourseByName(String courseName);
    List<Course> findCourseByUsers(Set<User> users);
}
