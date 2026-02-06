package com.codewithzhugeb1ao.familarbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

/**
 * DTO for displaying full employee details (all fields)
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailDTO {
    private String id;
    private String fullName;
    private String gender;
    private LocalDate birthDay;
    private String department;
    private String bankAccount;
    private String bank;
    private String sin;
    private String ptin;
    private String nationalId;
    private String address;
    private String phoneNo;
    private String zaloNo;
    private String email;
    private String hobby;
    private String favoriteSport;
    private String maritalStatus;
    private LocalDate dateIn;
    private String specialization;
    private String image;
    private Instant createdAt;
    private Instant updatedAt;
}
