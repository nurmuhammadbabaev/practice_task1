package peaksoft.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dao.DaoCourse;
import peaksoft.entity.Course;

import java.util.List;
@Service
public class ServiceCourseImpl implements ServiceCourse {

    private DaoCourse daoCourse;

    @Autowired
    public ServiceCourseImpl(DaoCourse daoCourse) {
        this.daoCourse = daoCourse;
    }

    @Transactional
    @Override
    public void saveCourse(Course course) {

        daoCourse.saveCourse(course);
    }

    @Transactional
    @Override
    public void removeCourseById(int id) {
        daoCourse.removeCourseById(id);
    }

    @Transactional
    @Override
    public Course getById(int id) {

        return daoCourse.getCourseById(id);
    }

    @Transactional
    @Override
    public List<Course> getAllCourse() {
        return daoCourse.getAllCourse();
    }

    @Transactional
    @Override
    public void update(int id, Course course) {
        daoCourse.update(id, course);
    }
}
