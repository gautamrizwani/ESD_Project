package com.esd_project.esd_project.controller;

import com.esd_project.esd_project.bean.Department;
import com.esd_project.esd_project.bean.Student;
import com.esd_project.esd_project.dao.DepartmentDAO;
import com.esd_project.esd_project.dao.impl.DepartmentDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("department")
public class DepartmentController {

    DepartmentDAO departmentDAO = new DepartmentDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_Department(Department department){
        System.out.printf(String.valueOf(department));
        if(departmentDAO.createDepartment(department)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding student").build();
    }
}
