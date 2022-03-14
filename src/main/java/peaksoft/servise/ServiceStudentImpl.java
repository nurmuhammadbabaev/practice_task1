package peaksoft.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.DaoStudent;
import peaksoft.entity.Student;

import java.util.List;

@Service
public class ServiceStudentImpl implements ServiceStudent {

    private DaoStudent daoStudent;

    @Autowired
    public ServiceStudentImpl(DaoStudent daoStudent) {
        this.daoStudent = daoStudent;
    }

    @Transactional
    @Override
    public void saveStudent(Student student) {
        daoStudent.saveStudent(student);

    }

    @Transactional
    @Override
    public void removeStudentById(int id) {
        daoStudent.removeStudentById(id);
    }

    @Transactional
    @Override
    public Student getById(int id) {
        return daoStudent.getById(id);
    }

    @Transactional
    @Override
    public List<Student> getAllStudent() {
        return daoStudent.getAllStudent();
    }

    @Transactional
    @Override
    public void update(int id, Student student) {
        daoStudent.update(id, student);
    }
}
