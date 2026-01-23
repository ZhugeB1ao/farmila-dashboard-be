package com.codewithzhugeb1ao.familarbackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * DTO để nhận dữ liệu Employee từ frontend (không bao gồm image vì image sẽ được gửi riêng qua MultipartFile)
 */
@Getter
@Setter
public class EmployeeDTO {
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
}
