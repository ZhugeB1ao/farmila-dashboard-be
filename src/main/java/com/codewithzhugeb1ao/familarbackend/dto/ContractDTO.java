package com.codewithzhugeb1ao.familarbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

/**
 * DTO for EmploymentContract
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDTO {
    private String id;
    private String contractNo;
    private String durationType;
    private String durationValue;
    private LocalDate startDate;
    private LocalDate endDate;
    private Instant createdAt;
    private Instant updatedAt;
}
