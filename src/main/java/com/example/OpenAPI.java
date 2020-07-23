package com.example;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(title = "SampleApp API",
                description = "This API allows CRUD operations on a SampleApp",
                version = "1.0",
                contact = @Contact(name = "MyContact", url = "https://mywebsite.com")),
        servers = {
                @Server(url = "http://localhost:8080")
        },
        externalDocs = @ExternalDocumentation(url = "https://mywiki.com", description = "MyApp wiki"),
        tags = {
                @Tag(name = "api", description = "My public/private/internal API"),
                @Tag(name = "SampleApp", description = "My SampleApp")
        }
)
public class OpenAPI extends Application {
}
