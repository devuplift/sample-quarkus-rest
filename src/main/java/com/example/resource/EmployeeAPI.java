package com.example.resource;

import com.example.domain.Employee;
import com.example.service.EmployeeService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.transaction.Transaction;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/")
public class EmployeeAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeAPI.class);

    private EmployeeService employeeService;

    @Inject
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @Metered(
            name = "employees-api-transactions",
            unit = MetricUnits.SECONDS,
            description = "Employees API Rate of transactions"
    )
    @Counted(
            name = "employees-api",
            displayName = "employeeAPI",
            description = "Number of call made to employee apis"
    )
    @Timed(
            name = "employees-api-average-transaction",
            unit = MetricUnits.SECONDS,
            description = "Employee API Average duration of transaction"
    )
    @Operation(summary = "Get all employees",
            description = "Get the full list of employees.")
    @Path("/employees")
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<Employee> employees() {
        LOGGER.info("Entered into employee method");

        return employeeService.employees();
    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/employee")
    public Response saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return Response.ok().build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/employee")
    public Response updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return Response.ok().build();
    }


    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/employee")
    public Response deleteEmployee(String email) {
        employeeService.deleteEmployee(email);
        return Response.ok().build();
    }
}
