package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DaoTeacherImpl implements DaoTeacher{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public void removeTeacherById(int id) {
entityManager.remove(getById(id));
    }

    @Override
    public Teacher getById(int id) {
        return entityManager.find(Teacher.class,id);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        List<Teacher>teacherList=entityManager.createQuery("SELECT t FROM Teacher t",Teacher.class).getResultList();

        return teacherList;
    }

    @Override
    public void update(int id, Teacher updateTeacher) {
Teacher teacher=getById(id);
teacher.setFirstName(updateTeacher.getFirstName());
teacher.setLastName(updateTeacher.getLastName());
teacher.setEmail(updateTeacher.getEmail());
teacher.setCourse(updateTeacher.getCourse());
entityManager.merge(teacher);

    }
}
