package com.esd_project.esd_project.controller;

import com.esd_project.esd_project.bean.Employee;
import com.esd_project.esd_project.bean.Student;
import com.esd_project.esd_project.dao.StudentDAO;
import com.esd_project.esd_project.dao.impl.StudentDAOImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("student")
public class StudentController {
    StudentDAO studentDAO = new StudentDAOImpl();

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_Student(Student student){
        System.out.printf(String.valueOf(student));
        List<Student> myList= studentDAO.getStudent();
        if(!myList.isEmpty()){
            return Response.status(200).entity(myList).build();
        }

        return Response.status(400).entity("Failure while getting student").build();
    }

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
