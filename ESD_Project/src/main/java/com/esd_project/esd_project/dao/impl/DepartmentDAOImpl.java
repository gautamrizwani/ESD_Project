package com.esd_project.esd_project.dao.impl;

import com.esd_project.esd_project.bean.Department;
import com.esd_project.esd_project.dao.DepartmentDAO;
import com.esd_project.esd_project.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public boolean createDepartment(Department department) {
        try(Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(department);
            transaction.commit();
            return true;
        }
        catch (HibernateException ex) {
            System.out.println(ex.getLocalizedMessage());
            return false;
        }
    }
}
