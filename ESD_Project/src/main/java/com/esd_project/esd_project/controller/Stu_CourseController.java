package com.esd_project.esd_project.controller;

import com.esd_project.esd_project.bean.Course;
import com.esd_project.esd_project.bean.Employee;
import com.esd_project.esd_project.bean.Stu_Course;
import com.esd_project.esd_project.bean.Student;
import com.esd_project.esd_project.dao.CourseDAO;
import com.esd_project.esd_project.dao.Stu_CourseDAO;
import com.esd_project.esd_project.dao.impl.CourseDAOImpl;
import com.esd_project.esd_project.dao.impl.Stu_CourseDAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("stucourse")
public class Stu_CourseController {

    Stu_CourseDAO stu_courseDAO = new Stu_CourseDAOImpl();

    @POST
    @Path("getstucou")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFacCourse(Course course){
        List<Stu_Course> myList= stu_courseDAO.getStuCourse(course);
        if(!myList.isEmpty()){
            return Response.status(200).entity(myList).build();
        }

        return Response.status(400).entity("Failure while getting Courses").build();
    }


}
