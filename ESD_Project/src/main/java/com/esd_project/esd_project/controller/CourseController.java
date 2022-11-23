package com.esd_project.esd_project.controller;

import com.esd_project.esd_project.bean.Course;
import com.esd_project.esd_project.bean.Department;
import com.esd_project.esd_project.dao.CourseDAO;
import com.esd_project.esd_project.dao.impl.CourseDAOImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("course")
public class CourseController {

    CourseDAO courseDAO = new CourseDAOImpl();

    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_Department(Course course){
        System.out.printf(String.valueOf(course));
        List<Course> myList= courseDAO.getCourse();
        if(!myList.isEmpty()){
            return Response.status(200).entity(myList).build();
        }

        return Response.status(400).entity("Failure while getting student").build();
    }


    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_Department(Course course){
        System.out.printf(String.valueOf(course));
        if(courseDAO.createCourse(course)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding student").build();
    }
}