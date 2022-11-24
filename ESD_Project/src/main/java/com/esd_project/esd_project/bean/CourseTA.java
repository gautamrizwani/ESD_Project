package com.esd_project.esd_project.bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class CourseTA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseTA_id;

    @ManyToMany
    @JoinColumn(name="course_id")
    private List<Course> courses;

    @ManyToMany
    @JoinColumn(name="student_id")
    private List<Student> students;

    public Integer getCourseTA_id() {
        return courseTA_id;
    }

    public void setCourseTA_id(Integer courseTA_id) {
        this.courseTA_id = courseTA_id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
