package com.arcyriea.em_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arcyriea.em_backend.api.model.Employee;
import com.arcyriea.em_backend.dto.EmployeeDto;
import com.arcyriea.em_backend.exceptions.ResourceNotFoundException;
import com.arcyriea.em_backend.repository.EmployeeRepository;
import com.arcyriea.em_backend.service.interfaces.IEmployeeService;
import com.mapper.EmployeeMapper;

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
    public EmployeeDto getEmployee(long id) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The employee with requested id:"+id+" could not be found!!!"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public Employee getEmployee(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEmployee'");
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {
        Employee employee = EmployeeMapper.mapToEmployee(dto);
        EmployeeDto savedEmployee = EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
        return savedEmployee;
    }
    
}
