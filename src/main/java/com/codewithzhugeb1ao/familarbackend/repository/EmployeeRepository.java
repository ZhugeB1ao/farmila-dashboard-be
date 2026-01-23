package com.codewithzhugeb1ao.familarbackend.repository;

import com.codewithzhugeb1ao.familarbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
