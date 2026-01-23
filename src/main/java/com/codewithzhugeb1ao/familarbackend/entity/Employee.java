package com.codewithzhugeb1ao.familarbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "gender", length = 20)
    private String gender;

    @Column(name = "birth_day")
    private LocalDate birthDay;

    @Column(name = "department", length = 100)
    private String department;

    @Column(name = "bank_account", length = 100)
    private String bankAccount;

    @Column(name = "bank", length = 100)
    private String bank;

    @Column(name = "sin", length = 50)
    private String sin;

    @Column(name = "ptin", length = 50)
    private String ptin;

    @Column(name = "national_id", length = 50)
    private String nationalId;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_no", length = 20)
    private String phoneNo;

    @Column(name = "zalo_no", length = 20)
    private String zaloNo;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "hobby", length = 100)
    private String hobby;

    @Column(name = "favorite_sport", length = 100)
    private String favoriteSport;

    @Column(name = "marital_status", length = 50)
    private String maritalStatus;

    @Column(name = "date_in")
    private LocalDate dateIn;

    @Column(name = "specialization", length = 100)
    private String specialization;

    @Column(name = "image")
    private String image;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at")
    private Instant updatedAt;


}