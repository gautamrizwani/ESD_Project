package com.esd_project.esd_project.dao.impl;

import com.esd_project.esd_project.bean.Course;
import com.esd_project.esd_project.bean.CourseTA;
import com.esd_project.esd_project.bean.Student;
import com.esd_project.esd_project.dao.CourseTADAO;
import com.esd_project.esd_project.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CourseTADAOImpl implements CourseTADAO {

    @Override
    public boolean createCourseTA(CourseTA courseTA) {
        try(Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(courseTA);
            transaction.commit();
            return true;
        }
        catch (HibernateException ex) {
            System.out.println(ex.getLocalizedMessage());
            return false;
        }
    }
}
