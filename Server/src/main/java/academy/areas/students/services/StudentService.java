package academy.areas.students.services;

import academy.areas.students.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Integer addStudent(final Student student);
    Student findStudentById(final Integer id);
    Student findStudentByUserName(final String userName);
    void disableStudentById(final Integer id);
    void updateStudent(final Student student);
}
