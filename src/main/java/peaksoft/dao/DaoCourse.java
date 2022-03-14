package peaksoft.dao;

import peaksoft.entity.Course;

import java.util.List;

public interface DaoCourse {
    void saveCourse(Course course);

    void removeCourseById(int id);

    Course getCourseById(int id);

    List<Course> getAllCourse();

    void update(int id,Course course);
}
