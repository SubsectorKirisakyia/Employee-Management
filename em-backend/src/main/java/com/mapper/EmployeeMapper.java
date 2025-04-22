package com.mapper;

import com.arcyriea.em_backend.api.model.Employee;
import com.arcyriea.em_backend.dto.EmployeeDto;
import com.arcyriea.em_backend.exceptions.ResourceNotFoundException;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        if (employee == null) throw new ResourceNotFoundException("Failed to retrieve Employee class to convert to EmployeeDTO"); //May not be necessary since we have Optional<T> to deal with null values already...
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto dto){
        if (dto == null) throw new ResourceNotFoundException("Failed to retrieve EmployeeDTO to convert to entity Employee class");
        return new Employee(
            dto.getId(),
            dto.getFirstName(),
            dto.getLastName(),
            dto.getEmail()
        );
    }
}
