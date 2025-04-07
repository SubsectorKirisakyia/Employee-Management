package com.arcyriea.em_backend.service;

import java.util.List;

import com.arcyriea.em_backend.api.model.Employee;

public interface IEmployeeService {
    List<Employee> getEmployees();
    Employee getEmployee(int id);
    Employee getEmployee(String email);
}
