package com.arcyriea.em_backend.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.arcyriea.em_backend.api.model.Employee;
import com.arcyriea.em_backend.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeService.getEmployees();

        return employees;
    }
    
}
