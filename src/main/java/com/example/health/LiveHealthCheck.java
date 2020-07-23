package com.example.health;

import org.eclipse.microprofile.health.*;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
//@Liveness
//@Readiness
public class LiveHealthCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder checkResponseBuilder = HealthCheckResponse.named("My LiveHealthCheck");

            //return checkResponseBuilder.up().build();

            return checkResponseBuilder.down()
                    .withData("error", "Some error occurred")
                    .withData("System", "ABC system is down")
                    .build();


    }
}
