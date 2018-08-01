package academy.areas.students.services;

import academy.areas.students.entities.Student;
//import academy.areas.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServicesImpl implements StudentServices{
   /* private StudentRepository studentRepository;

    @Autowired
    public StudentServicesImpl(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }*/
}
