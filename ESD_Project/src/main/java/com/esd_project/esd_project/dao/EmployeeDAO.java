package com.esd_project.esd_project.dao;

import com.esd_project.esd_project.bean.Employee;

import java.util.List;

public interface EmployeeDAO {

    boolean createEmployee(Employee employee);

    List<Employee> getEmployee();

    Employee login(Employee employee);

}
