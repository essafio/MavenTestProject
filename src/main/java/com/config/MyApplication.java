package com.config;


import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        // Register resources and providers using package-scanning.
        packages("com");

        register(RolesAllowedDynamicFeature.class);
        register(JacksonFeature.class);

        // Register my custom provider - not needed if it's in my.package.
        //register(SecurityRequestFilter.class);
        // Register an instance of LoggingFilter.
        //register(new LoggingFilter(LOGGER, true));

        // Enable Tracing support.
        //property(ServerProperties.TRACING, "ALL");
    }
}
