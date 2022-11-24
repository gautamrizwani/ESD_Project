package com.esd_project.esd_project.controller;

import com.esd_project.esd_project.bean.Employee;
import com.esd_project.esd_project.dao.EmployeeDAO;
import com.esd_project.esd_project.dao.impl.EmployeeDAOImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("employee")
public class EmployeeController {

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_Employee(Employee employee){
        System.out.printf(String.valueOf(employee));
        List<Employee> myList= employeeDAO.getEmployee();
        if(!myList.isEmpty()){
            return Response.status(200).entity(myList).build();
        }

        return Response.status(400).entity("Failure while getting employee").build();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Employee employee) {
        Employee loggedInEmployee = employeeDAO.login(employee);

        if (loggedInEmployee == null)
            return Response.status(401).build();
        else
            return Response.ok().entity(loggedInEmployee).build();
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_Employee(Employee employee){
        System.out.printf(String.valueOf(employee));
        if(employeeDAO.createEmployee(employee)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding student").build();
    }
}
