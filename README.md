# sample-quarkus project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

# Tools
* JDK 11/12
* Maven 3.6.3


## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `sample-quarkus-rest-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware it’s not an Uber jar or Fat jar.Dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/sample-quarkus-rest-1.0-SNAPSHOT-runner.jar`.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/sample-quarkus-rest-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.


# Creating Quarkus Project from command line
* Run `mvn io.quarkus:quarkus-maven-plugin:1.6.0.Final:create` from command prompt or terminal
* Enter values for group id , artifact id, version

# Creating project using Quarkus Initializer
* Visit https://code.quarkus.io/

# Creating project from IDE 
* Refer for IDE support https://quarkus.io/blog/march-of-ides/

# Postman Collection for API 
* Refer [quarkus.postman_collection.json](quarkus.postman_collection.json)


# Reading properties from config properties
* @ConfigProperty annotation to read properties from application.properties file
* Properties can be overridden from command line -Dmyprop=test will override
* The YAML format supported for configuring the application. In this case, the file is named application.yaml or application.yml.
* To start using the YAML configuration file, you need to add the config-yaml extension. Rum command ./mvnw quarkus:add-extension -Dextensions="config-yaml"

# Logging

* quarkus.log.level=DEBUG
* quarkus.log.category."<category-name>".level for example quarkus.log.category.“com.example”.level=INFO 
* Log Level available are TRACE, DEBUG, INFO,WARN, ERROR, FATAL


# JSON Logging
* Add dependency quarkus-logging-json
* You can use quarkus.log.console.json.pretty-print=true to make viewing log easy
* You can also disable JSON logging based on profile %dev.quarkus.log.console.json=false
* Refer [application.properties](src/main/resources/application.properties)

# Health
* Liveness – determine if application is up
* Readiness – determine if application is ready to serve requests
* Implement HealthCheck to create custom health check
* Refer [health package](src/main/java/com/example/health)


#Persistence with hibernate PanacheEntity
* Simplified persistence
* Entity class extends PanacheEntity 
* PanacheEntity Provide utility methods, default Id, default toString method etc.
* Entity fields should be public
* Any time you access field internally it will call setter/getter methods


* Refer - [EmpEntity](src/main/java/com/example/entity/EmpEntity.java)

# Metrics
* @Counted – can be used at class or method level to find how many time it was called
* @Metred – can be used at class or method level to find rate at which it was called
* @Timed – can be used at class or method level to find how long it took to finish
* Refer [EmployeeAPI](src/main/java/com/example/resource/EmployeeAPI.java)


# Fault Tolerance
* Add extension quarkus-smallrye-fault-tolerance
* mvnw quarkus:add-extension -Dextensions="quarkus-smallrye-fault-tolerance"
* @Retry
* @Fallback
* @Timeout
* Refer [HelloAPI](src/main/java/com/example/HelloAPI.java)


# Useful Links
* https://microprofile.io/
* https://quarkus.io/
* https://www.graalvm.org/
* https://quarkus.io/guides/hibernate-orm-panache
* https://smallrye.io/
* http://microprofile.io/
* http://openjdk.java.net/jeps/295
* https://quarkus.io/blog/march-of-ides/






