package com.esd_project.esd_project.bean;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "course_id", "student_id"})})
public class Stu_Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stu_course_id;

    @OneToOne
    @JoinColumn(name="course_id")
    private Course course;

    @OneToOne
    @JoinColumn(name="student_id")
    private Student student;

    public Integer getStu_course_id() {
        return stu_course_id;
    }

    public void setStu_course_id(Integer stu_course_id) {
        this.stu_course_id = stu_course_id;
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
