package com.esd_project.esd_project.controller;

import com.esd_project.esd_project.bean.CourseTA;
import com.esd_project.esd_project.dao.CourseTADAO;
import com.esd_project.esd_project.dao.impl.CourseTADAOImpl;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("courseta")
public class CourseTAController {
    CourseTADAO courseTADAO = new CourseTADAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_course_ta(CourseTA courseTA) {
        System.out.println(courseTA);
        if(courseTADAO.createCourseTA(courseTA))
        {
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding CourseTA").build();
    }
}
