package com.esd_project.esd_project.bean;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table
public class Student {

    public Integer getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(Integer student_Id) {
        this.student_Id = student_Id;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public Integer getTotal_credits() {
        return total_credits;
    }

    public void setTotal_credits(Integer total_credits) {
        this.total_credits = total_credits;
    }

    public Date getGraduation_year() {
        return graduation_year;
    }

    public void setGraduation_year(Date graduation_year) {
        this.graduation_year = graduation_year;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_Id;

    @Column(nullable = false, unique = true)
    private String roll_number;

    @Column(nullable = false)
    private String first_name;

    @Column
    private String last_name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String photograph_path;

    @Column(nullable = false, columnDefinition = "float default 0.0")
    private float cgpa;

    @Column(nullable = false)
    private Integer total_credits;

    @Column
    private Date graduation_year;
}
