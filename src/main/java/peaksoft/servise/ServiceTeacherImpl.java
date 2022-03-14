package peaksoft.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.DaoTeacher;
import peaksoft.entity.Teacher;

import java.util.List;
@Service
public class ServiceTeacherImpl implements ServiceTeacher {

    private DaoTeacher daoTeacher;

    @Autowired
    public ServiceTeacherImpl(DaoTeacher daoTeacher) {
        this.daoTeacher = daoTeacher;
    }

    @Transactional
    @Override
    public void saveTeacher(Teacher teacher) {
        daoTeacher.saveTeacher(teacher);
    }

    @Transactional
    @Override
    public void removeTeacherById(int id) {
        daoTeacher.removeTeacherById(id);
    }

    @Transactional
    @Override
    public Teacher getById(int id) {
        return daoTeacher.getById(id);
    }

    @Transactional
    @Override
    public List<Teacher> getAllTeacher() {
        return daoTeacher.getAllTeacher();
    }

    @Transactional
    @Override
    public void update(int id, Teacher teacher) {
        daoTeacher.update(id, teacher);
    }
}
