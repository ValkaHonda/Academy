package academy.areas.teachers.services;

import academy.areas.courses.entities.Course;
import academy.areas.courses.repositories.CourseRepository;
import academy.areas.students.entities.Student;
import academy.areas.teachers.entities.Teacher;
import academy.areas.teachers.repositories.TeacherRepository;
import academy.areas.users.repositories.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TeacherServicesImpl implements TeacherServices {
    private TeacherRepository teacherRepository;
    private AbstractRepository<Teacher> abstractRepository;

    @Autowired
    public TeacherServicesImpl(final TeacherRepository teacherRepository
        , final AbstractRepository<Teacher> abstractRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Integer createTeacher(Teacher teacher) {
        if (teacher != null){
            this.teacherRepository.saveAndFlush(teacher);
            return teacher.getId();
        }
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        System.out.println("could be a bug");
//        Not ready for abstractRepository!!!!!!!!!!!!!
//        System.out.println(this.abstractRepository.findAllByActiveTrue());
        System.out.println("No?");
        return this.teacherRepository.findAllByActiveTrue();
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return this.teacherRepository.findTeacherByIdAndActiveTrue(id);
    }

    @Override
    public void disableTeacher(Integer id) {
        Teacher teacher = this.teacherRepository.findTeacherByIdAndActiveTrue(id);
        if (teacher != null){
            teacher.setActive(false);
            this.teacherRepository.saveAndFlush(teacher);
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        if (teacher != null && this.teacherRepository
                .findTeacherByIdAndActiveTrue(teacher.getId()) != null){
            this.teacherRepository.saveAndFlush(teacher);
        }
    }
}
