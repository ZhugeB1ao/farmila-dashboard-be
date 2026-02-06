package com.codewithzhugeb1ao.familarbackend.repository;

import com.codewithzhugeb1ao.familarbackend.entity.EmploymentContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ContractRepository extends JpaRepository<EmploymentContract, String> {

    // Find contracts by employee ID
    List<EmploymentContract> findByEmployeeId(String employeeId);

    // Find active contract (end_date >= today or end_date is null)
    @Query("SELECT c FROM EmploymentContract c WHERE c.employee.id = :employeeId AND (c.endDate >= :today OR c.endDate IS NULL) ORDER BY c.startDate DESC")
    Optional<EmploymentContract> findActiveContract(@Param("employeeId") String employeeId, @Param("today") LocalDate today);

    default Optional<EmploymentContract> findActiveContract(String employeeId) {
        return findActiveContract(employeeId, LocalDate.now());
    }
}