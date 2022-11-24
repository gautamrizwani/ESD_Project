package com.esd_project.esd_project.dao.impl;

import com.esd_project.esd_project.bean.Employee;
import com.esd_project.esd_project.bean.Student;
import com.esd_project.esd_project.dao.StudentDAO;
import com.esd_project.esd_project.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public boolean createStudent(Student student) {
        try(Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
            return true;
        }
        catch (HibernateException ex) {
            System.out.println(ex.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public List<Student> getStudent() {
        List<Student> myList = new ArrayList<>();

        try (Session session = HibernateSessionUtil.getSession()){
            for (
                    final Object dill : session
                    .createQuery("FROM Student").list()
            )
                myList.add((Student) dill);

        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return myList;
    }
}
