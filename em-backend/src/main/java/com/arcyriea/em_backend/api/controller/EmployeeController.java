package com.arcyriea.em_backend.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.arcyriea.em_backend.api.model.Employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EmployeeController {
    
    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        return employees;
    }
    
}
