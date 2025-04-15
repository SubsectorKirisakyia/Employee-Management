package com.mapper;

import com.arcyriea.em_backend.api.model.Employee;
import com.arcyriea.em_backend.dto.EmployeeDto;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        if (employee == null) return null; //failsafe
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto dto){
        if (dto == null) return null; //failsafe
        return new Employee(
            dto.getId(),
            dto.getFirstName(),
            dto.getLastName(),
            dto.getEmail()
        );
    }
}
