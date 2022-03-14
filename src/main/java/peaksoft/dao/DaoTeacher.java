package peaksoft.dao;

import peaksoft.entity.Teacher;

import java.util.List;

public interface DaoTeacher {
    void saveTeacher(Teacher teacher);

    void removeTeacherById(int id);

    Teacher getById(int id);

    List<Teacher> getAllTeacher();

    void update(int id,Teacher teacher);
}
