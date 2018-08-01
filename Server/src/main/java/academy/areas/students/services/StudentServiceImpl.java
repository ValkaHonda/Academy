package academy.areas.students.services;

import academy.areas.students.entities.Student;
import academy.areas.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllUsers() {
        Student student = new Student("honda", "Valka", "aleksandrov", "mail", "somepass", null, null,true);
        this.addStudent(student);
        return this.studentRepository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        this.studentRepository.saveAndFlush(student);
    }
}
