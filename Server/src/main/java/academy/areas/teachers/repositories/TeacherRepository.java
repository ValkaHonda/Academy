package academy.areas.teachers.repositories;

import academy.areas.teachers.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    List<Teacher> findAllByActiveTrue();
    Teacher findTeacherByIdAndActiveTrue(final Integer id);
    Teacher findTeacherByUserNameAndActiveTrue(final String userName);
}
