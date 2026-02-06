package com.codewithzhugeb1ao.familarbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO for displaying employee list (minimal fields)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeListDTO {
    private String id;
    private String fullName;
    private String gender;
    private LocalDate birthDay;
    private String department;
    private String bankAccount;  // Account No
    private String sin;
    private String ptin;
}
