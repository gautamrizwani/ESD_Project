package com.esd_project.esd_project;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
//        register(CORS)
        packages("com.esd_project.esd_project");
    }
}
