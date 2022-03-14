package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Group;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class DaoGroupImpl implements DaoGroup{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveGroup(Group group) {

        entityManager.persist(group);
    }

    @Override
    public void removeGroupById(int id) {
entityManager.remove(getById(id));
    }

    @Override
    public Group getById(int id) {

        return entityManager.find(Group.class,id);
    }

    @Override
    public List<Group> getAllGroup() {
        List<Group>groupList=entityManager.createQuery("select g from Group g",Group.class).getResultList();

        return groupList;
    }

    @Override
    public void update(int id, Group updateGroup) {
        Group group=getById(id);
        group.setGroupName(updateGroup.getGroupName());
        group.setCourse(updateGroup.getCourse());
        group.setDateOfStart(updateGroup.getDateOfStart());
        group.setDateOfFinish(updateGroup.getDateOfFinish());
        group.setStudents(updateGroup.getStudents());
        entityManager.merge(group);

    }
}
