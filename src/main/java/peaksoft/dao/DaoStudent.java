package peaksoft.dao;

import peaksoft.entity.Student;

import java.util.List;

public interface DaoStudent {
    void saveStudent(Student student);

    void removeStudentById(int id);

    Student getById(int id);

    List<Student> getAllStudent();

    void update(int id,Student student);
}
