package academy.areas.teachers.services;

import academy.areas.teachers.entities.Teacher;

import java.util.List;

public interface TeacherServices {
    Integer createTeacher(Teacher teacher);
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(final Integer id);
    void disableTeacher(final Integer id);
    void updateTeacher(Teacher teacher);
}
