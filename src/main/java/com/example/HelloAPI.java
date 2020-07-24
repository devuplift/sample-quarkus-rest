package com.example;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/")
public class HelloAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloAPI.class);

    @ConfigProperty(name = "hi.message")
    String messgae;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "hello";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hi")
    @Retry(maxRetries = 3, delay = 1000, retryOn = IOException.class)
    @Fallback(fallbackMethod = "hifallback")
    public String hi() throws Exception {
        LOGGER.info("######### ");
        throw new Exception();

    }

    public String hifallback(){
        LOGGER.info("hi from fallback");
        return messgae;
    }


}