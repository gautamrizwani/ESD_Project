package com.esd_project.esd_project.dao.impl;

import com.esd_project.esd_project.bean.Course;
import com.esd_project.esd_project.bean.Stu_Course;
import com.esd_project.esd_project.dao.Stu_CourseDAO;
import com.esd_project.esd_project.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class Stu_CourseDAOImpl implements Stu_CourseDAO {
    @Override
    public List<Stu_Course> getStuCourse(Course course) {
        List<Stu_Course> myList = new ArrayList<>();

        try (Session session = HibernateSessionUtil.getSession()){
            for (
                    final Object dill : session
                    .createQuery("FROM Stu_Course WHERE course = :courseId").setParameter("courseId", course).list()
            )
                myList.add((Stu_Course) dill);

        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return myList;
    }
}
