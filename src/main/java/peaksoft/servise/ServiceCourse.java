package peaksoft.servise;

import org.springframework.stereotype.Service;
import peaksoft.entity.Course;

import java.util.List;
public interface ServiceCourse {

    void saveCourse(Course course);

    void removeCourseById(int id);

    Course getById(int id);

    List<Course> getAllCourse();

    void update(int id,Course course);
}
