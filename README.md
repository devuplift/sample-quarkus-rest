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


# Useful Links
* https://microprofile.io/
* https://quarkus.io/
* https://www.graalvm.org/
* https://quarkus.io/guides/hibernate-orm-panache
* https://smallrye.io/
* http://microprofile.io/
* http://openjdk.java.net/jeps/295
* https://quarkus.io/blog/march-of-ides/






