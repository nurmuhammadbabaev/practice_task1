package peaksoft.dao;

import org.springframework.stereotype.Repository;

import peaksoft.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DaoCourseImpl implements DaoCourse {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public void removeCourseById(int id) {
        entityManager.remove(getCourseById(id));

    }

    @Override
    public Course getCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> getAllCourse() {
        List<Course> courseList = entityManager.createQuery("SELECT co FROM Course co ", Course.class).getResultList();

        return courseList;
    }

    @Override
    public void update(int id, Course updateCourse) {
        Course course = getCourseById(id);
        course.setCourseName(updateCourse.getCourseName());
        course.setCompany(updateCourse.getCompany());
        course.setDuration(updateCourse.getDuration());
        course.setGroups(updateCourse.getGroups());
        course.setTeacher(updateCourse.getTeacher());
        entityManager.merge(course);

    }
}
