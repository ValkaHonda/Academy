package academy.areas.teachers.services;

import academy.areas.students.entities.Student;
import academy.areas.teachers.entities.Teacher;
import academy.areas.teachers.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServicesImpl implements TeacherServices {
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServicesImpl(final TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Integer createTeacher(Teacher teacher) {
        if (teacher != null){
            this.teacherRepository.saveAndFlush(teacher);
            return this.teacherRepository
                    .findTeacherByUserNameAndActiveTrue(teacher.getUserName())
                    .getId();
        }
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
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
