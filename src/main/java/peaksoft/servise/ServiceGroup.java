package peaksoft.servise;

import peaksoft.entity.Group;

import java.util.List;
public interface ServiceGroup {

    void saveGroup(Group group);

    void removeGroupById(int id);

    Group getById(int id);

    List<Group> getAllGroup();

    void update(int id,Group group);
}
