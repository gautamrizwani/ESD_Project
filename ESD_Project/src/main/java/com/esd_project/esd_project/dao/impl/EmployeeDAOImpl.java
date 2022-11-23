package com.esd_project.esd_project.dao.impl;

import com.esd_project.esd_project.bean.Employee;
import com.esd_project.esd_project.dao.EmployeeDAO;
import com.esd_project.esd_project.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public boolean createEmployee(Employee employee) {
        try(Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            transaction.commit();
            return true;
        }
        catch (HibernateException ex) {
            System.out.println(ex.getLocalizedMessage());
            return false;
        }
    }
}
