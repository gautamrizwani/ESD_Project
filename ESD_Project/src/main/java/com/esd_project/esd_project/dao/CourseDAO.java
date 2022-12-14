package com.esd_project.esd_project.dao;

import com.esd_project.esd_project.bean.Course;
import com.esd_project.esd_project.bean.Employee;

import java.util.List;

public interface CourseDAO {

    boolean createCourse(Course course);
    List<Course> getCourse();

    List<Course> getFacCourse(Employee employee);
}
