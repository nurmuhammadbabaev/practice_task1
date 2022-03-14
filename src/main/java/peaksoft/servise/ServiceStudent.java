package peaksoft.servise;

import org.springframework.stereotype.Service;
import peaksoft.entity.Student;

import java.util.List;
@Service
public interface ServiceStudent {
    void saveStudent(Student student);

    void removeStudentById(int id);

    Student getById(int id);

    List<Student> getAllStudent();

    void update(int id,Student student);
}
