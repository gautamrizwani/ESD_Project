package com.esd_project.esd_project.dao;

import com.esd_project.esd_project.bean.Course;

import java.util.List;

public interface CourseDAO {

    boolean createCourse(Course course);
    List<Course> getCourse();
}
