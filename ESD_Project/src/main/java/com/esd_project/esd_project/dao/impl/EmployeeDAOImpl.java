package com.esd_project.esd_project.dao.impl;

import com.esd_project.esd_project.bean.Course;
import com.esd_project.esd_project.bean.Employee;
import com.esd_project.esd_project.dao.EmployeeDAO;
import com.esd_project.esd_project.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Employee> getEmployee() {
        List<Employee> myList = new ArrayList<>();

        try (Session session = HibernateSessionUtil.getSession()){
            for (
                    final Object dill : session
                    .createQuery("FROM Employee").list()
            )
                myList.add((Employee) dill);

        }
        catch (HibernateException exception) {
            System.out.println(exception.getLocalizedMessage());
        }

        return myList;
    }

    @Override
    public Employee login(Employee employee) {
        try (Session session = HibernateSessionUtil.getSession();){
            String employeeEmail = employee.getEmail();
            String employeePassword = employee.getPassword();

            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                                    "FROM Employee WHERE email = :employeeEmail and password = :employeePassword"
                            )
                            .setParameter("employeeEmail", employeeEmail)
                            .setParameter("employeePassword", employeePassword)
                            .list()
            );

            // If no valid Student found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return (Employee) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }
}
