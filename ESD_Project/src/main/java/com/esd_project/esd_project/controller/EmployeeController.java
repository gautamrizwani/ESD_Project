package com.esd_project.esd_project.controller;

import com.esd_project.esd_project.bean.Department;
import com.esd_project.esd_project.bean.Employee;
import com.esd_project.esd_project.dao.EmployeeDAO;
import com.esd_project.esd_project.dao.impl.EmployeeDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("employee")
public class EmployeeController {

    EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_Department(Employee employee){
        System.out.printf(String.valueOf(employee));
        if(employeeDAO.createEmployee(employee)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding student").build();
    }
}
