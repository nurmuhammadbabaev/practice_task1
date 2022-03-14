package peaksoft.servise;

import org.springframework.stereotype.Service;
import peaksoft.entity.Teacher;

import java.util.List;

public interface ServiceTeacher {
    void saveTeacher(Teacher teacher);

    void removeTeacherById(int id);

    Teacher getById(int id);

    List<Teacher> getAllTeacher();

    void update(int id,Teacher teacher);
}
