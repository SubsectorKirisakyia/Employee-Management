package com.arcyriea.em_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arcyriea.em_backend.api.model.Employee;
import com.arcyriea.em_backend.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        // TODO Auto-generated method stub
        List<Employee> employees = employeeRepository.findAll();

        return employees;
    }

    @Override
    public Employee getEmployee(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployee'");
    }

    @Override
    public Employee getEmployee(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployee'");
    }
    
}
