package com.esd_project.esd_project;

import com.esd_project.esd_project.util.CORSFilter;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(CORSFilter.class);
        packages("com.esd_project.esd_project");
    }
}
