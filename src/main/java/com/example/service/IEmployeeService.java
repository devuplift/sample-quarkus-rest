package com.example.service;

import com.example.domain.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> employees();


    void saveEmployee(Employee employee);


    void updateEmployee(Employee employee);


    void deleteEmployee(String email) ;
}
