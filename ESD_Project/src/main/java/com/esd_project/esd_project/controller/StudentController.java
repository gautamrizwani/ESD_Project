package com.esd_project.esd_project.controller;

import com.esd_project.esd_project.bean.Student;
import com.esd_project.esd_project.dao.StudentDAO;
import com.esd_project.esd_project.dao.impl.StudentDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("student")
public class StudentController {
    StudentDAO studentDAO = new StudentDAOImpl();
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_Student(Student student){
        System.out.printf(String.valueOf(student));
        if(studentDAO.createStudent(student)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding student").build();
    }

}
