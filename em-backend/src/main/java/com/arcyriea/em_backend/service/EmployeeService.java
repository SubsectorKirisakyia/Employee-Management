package com.arcyriea.em_backend.service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<EmployeeDto> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> employeesDto = employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
        return employeesDto;
    }

    @Override
    public EmployeeDto getEmployee(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("The employee with requested id:"+id+" could not be found!!!"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto getEmployee(String email) {
        Employee employee = employeeRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("The employee with the following email: "+email+" could not be found!!!"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {
        Employee employee = EmployeeMapper.mapToEmployee(dto);
        EmployeeDto savedEmployee = EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
        return savedEmployee;
    }

    @Override
    public EmployeeDto updateEmployee(long id, EmployeeDto dto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Failed to retrieve or did not found Employee with id:"+id+" for modification request!!!"));
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        EmployeeDto savedEmployee = EmployeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
        return savedEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity does not exists or already deleted, please verify on your database: "+id));
        employeeRepository.delete(employee);
    }
    
}
