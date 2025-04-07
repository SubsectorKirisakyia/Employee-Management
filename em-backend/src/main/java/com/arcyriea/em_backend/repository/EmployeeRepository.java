package com.arcyriea.em_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arcyriea.em_backend.api.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
