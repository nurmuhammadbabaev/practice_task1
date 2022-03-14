package peaksoft.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "course_id")
    private int id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration")
    private String duration;

    @ManyToOne(cascade =CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(mappedBy = "course")
    private List<Group> groups;

   @OneToOne(mappedBy = "course")
    private Teacher teacher;

    public Course() {
    }

    public Course(String courseName, String duration,  List<Group> groups, Teacher teacher) {
        this.courseName = courseName;
        this.duration = duration;
        this.groups = groups;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", company=" + company +
                ", groups=" + groups +
                ", teacher=" + teacher +
                '}';
    }
}
