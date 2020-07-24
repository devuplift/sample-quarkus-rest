package com.example.service;

import com.example.domain.Employee;
import com.example.entity.EmpEntity;
import com.example.mapper.EmpMapper;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class EmployeeService implements IEmployeeService {


    private EmpMapper empMapper;

    @Inject
    public void setEmpMapper(EmpMapper empMapper) {
        this.empMapper = empMapper;
    }

    @Transactional
    public List<Employee> employees() {
        List<Employee> employees = new ArrayList<>();
        List<EmpEntity> empEntityList = EmpEntity.listAll();
        for (EmpEntity entity : empEntityList) {
            employees.add(empMapper.mapToDomain(entity));
        }
        return employees;
    }

    @Transactional
    public void saveEmployee(Employee employee) {
        empMapper.mapToEntity(employee).persist();
    }

    @Transactional
    public void updateEmployee(Employee employee) {
        EmpEntity empEntity = EmpEntity.findByEmail(employee.getEmail());
        empEntity.setLastName(employee.getLastName());
        empEntity.setFirstName(employee.getFirstName());
        empEntity.persist();
    }

    @Transactional
    public void deleteEmployee(String email) {
        EmpEntity.delete("email", email);
    }

}
