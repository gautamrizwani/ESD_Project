package com.esd_project.esd_project.dao;

import com.esd_project.esd_project.bean.Employee;
import com.esd_project.esd_project.bean.Student;

import java.util.List;

public interface StudentDAO {
    boolean createStudent(Student student);

    List<Student> getStudent();
}
