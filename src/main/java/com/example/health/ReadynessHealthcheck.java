package com.example.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
//@Readiness
public class ReadynessHealthcheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder checkResponseBuilder = HealthCheckResponse.named("My LiveHealthCheck");

        //return checkResponseBuilder.up().build();

        // Do some custom check
        return checkResponseBuilder.down()
                .withData("error", "Some error occurred")
                .withData("system" , "XYZ system is down")
                .build();


    }
}
