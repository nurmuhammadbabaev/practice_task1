package peaksoft.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.DaoGroup;
import peaksoft.entity.Group;

import java.util.List;

@Service
public class ServiceGroupImpl implements ServiceGroup {

    private DaoGroup daoGroup;

    @Autowired
    public ServiceGroupImpl(DaoGroup daoGroup) {
        this.daoGroup = daoGroup;
    }
    @Transactional
    @Override
    public void saveGroup(Group group) {
        daoGroup.saveGroup(group);
    }
    @Transactional
    @Override
    public void removeGroupById(int id) {
        daoGroup.removeGroupById(id);
    }
    @Transactional
    @Override
    public Group getById(int id) {
        return daoGroup.getById(id);
    }
    @Transactional
    @Override
    public List<Group> getAllGroup() {
        return daoGroup.getAllGroup();
    }
    @Transactional
    @Override
    public void update(int id, Group group) {
        daoGroup.update(id, group);
    }
}
