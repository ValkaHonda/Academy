package academy.areas.teachers.services;

import academy.areas.teachers.entities.Teacher;
import academy.areas.teachers.model.TeacherMV;

import java.util.List;

public interface TeacherServices {
    Integer createTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();
    TeacherMV getTeacherById(final Integer id);
    void disableTeacher(final Integer id);
    void updateTeacher(Teacher teacher);
}
