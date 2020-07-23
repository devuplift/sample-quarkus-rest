package com.example.mapper;

import com.example.domain.Employee;
import com.example.entity.EmpEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmpMapper {

    public EmpEntity mapToEntity(Employee employee) {
        EmpEntity entity = new EmpEntity();
        entity.setEmail(employee.getEmail());
        entity.setFirstName(employee.getFirstName());
        entity.setLastName(employee.getLastName());
        return entity;
    }

    public Employee mapToDomain(EmpEntity entity) {
        Employee employee = new Employee();
        employee.setEmail(entity.getEmail());
        employee.setFirstName(entity.getFirstName());
        employee.setLastName(entity.getLastName());
        return employee;
    }
}
