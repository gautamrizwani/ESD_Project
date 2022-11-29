package com.esd_project.esd_project.dao;

import com.esd_project.esd_project.bean.Course;
import com.esd_project.esd_project.bean.Employee;
import com.esd_project.esd_project.bean.Stu_Course;

import java.util.List;

public interface Stu_CourseDAO {

    List<Stu_Course> getStuCourse(Course course);

}
