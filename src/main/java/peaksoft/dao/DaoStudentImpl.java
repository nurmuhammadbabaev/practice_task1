package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class DaoStudentImpl implements DaoStudent{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void removeStudentById(int id) {
entityManager.remove(getById(id));
    }

    @Override
    public Student getById(int id) {

        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student>studentList=entityManager.createQuery("SELECT s FROM Student s",Student.class).getResultList();

        return studentList;
    }

    @Override
    public void update(int id, Student updateStudent) {
        Student student=getById(id);
        student.setFirstName(updateStudent.getFirstName());
        student.setLastName(updateStudent.getLastName());
        student.setEmail(updateStudent.getEmail());
        student.setGroup(updateStudent.getGroup());
        entityManager.merge(student);

    }
}
