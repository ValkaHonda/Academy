package academy.areas.students.services;

import academy.areas.students.entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(final Student student);
    Student findStudentById(final Integer id);
}
