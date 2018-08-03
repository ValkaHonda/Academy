package academy.areas.teachers.services;

import academy.areas.courses.entities.Course;
import academy.areas.courses.repositories.CourseRepository;
import academy.areas.students.entities.Student;
import academy.areas.teachers.entities.Teacher;
import academy.areas.teachers.model.TeacherMV;
import academy.areas.teachers.repositories.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            return teacher.getId();
        }
        return null;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return this.teacherRepository.findAllByActiveTrue();
    }

    @Override
    public TeacherMV getTeacherById(Integer id) {
        Teacher teacher = this.teacherRepository.findTeacherByIdAndActiveTrue(id);


        ModelMapper modelMapper = new ModelMapper();

        TeacherMV teacherMV = modelMapper.map(teacher,TeacherMV.class);





        return teacherMV;
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
