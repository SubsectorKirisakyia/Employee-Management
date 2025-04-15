package com.arcyriea.em_backend.service.interfaces;

import java.util.List;

import com.arcyriea.em_backend.api.model.Employee;
import com.arcyriea.em_backend.dto.EmployeeDto;

public interface IEmployeeService {
    List<Employee> getEmployees();
    Employee getEmployee(int id);
    Employee getEmployee(String email);
    EmployeeDto createEmployee(EmployeeDto dto);
}
