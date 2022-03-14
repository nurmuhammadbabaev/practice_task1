package peaksoft.dao;

import peaksoft.entity.Group;

import java.util.List;

public interface DaoGroup {
   void saveGroup(Group group);

    void removeGroupById(int id);

    Group getById(int id);

    List<Group> getAllGroup();

    void update(int id,Group group);

}
