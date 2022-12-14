package com.esd_project.esd_project.bean;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "course_id", "student_id"})})
public class CourseTA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseTA_id;

    @OneToOne//(cascade = {CascadeType.ALL})
    @JoinColumn(name="course_id")
    private Course course;

    @OneToOne//(cascade = {CascadeType.ALL})
    @JoinColumn(name="student_id")
    private Student student;

    public Integer getCourseTA_id() {
        return courseTA_id;
    }

    public void setCourseTA_id(Integer courseTA_id) {
        this.courseTA_id = courseTA_id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
