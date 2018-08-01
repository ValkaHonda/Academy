package academy.areas.teachers.services;

import academy.areas.teachers.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServicesImpl implements TeacherServices {
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServicesImpl(final TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

}
