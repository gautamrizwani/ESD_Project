package com.esd_project.esd_project.dao.impl;

import com.esd_project.esd_project.bean.Course;
import com.esd_project.esd_project.bean.Employee;
import com.esd_project.esd_project.dao.CourseDAO;
import com.esd_project.esd_project.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean createCourse(Course course) {
        try(Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
            return true;
        }
        catch (HibernateException ex) {
            System.out.println(ex.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Course> getCourse() {
        List<Course> myList = new ArrayList<>();

        try (Session session = HibernateSessionUtil.getSession()){
            for (
                    final Object dill : session
                    .createQuery("FROM Course").list()
                )
                myList.add((Course) dill);

        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return myList;
    }

    @Override
    public List<Course> getFacCourse(Employee employee) {
        List<Course> myList = new ArrayList<>();

        try (Session session = HibernateSessionUtil.getSession()){
            for (
                    final Object dill : session
                    .createQuery("FROM Course WHERE employee = :employeeId").setParameter("employeeId", employee).list()
            )
                myList.add((Course) dill);

        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return myList;
    }
}
