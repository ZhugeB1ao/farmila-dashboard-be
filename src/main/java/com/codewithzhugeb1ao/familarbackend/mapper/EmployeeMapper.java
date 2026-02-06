package com.codewithzhugeb1ao.familarbackend.mapper;

import com.codewithzhugeb1ao.familarbackend.dto.EmployeeDetailDTO;
import com.codewithzhugeb1ao.familarbackend.dto.EmployeeListDTO;
import com.codewithzhugeb1ao.familarbackend.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    /* ========= DTO -> ENTITY ========= */

    public Employee toEntity(EmployeeDetailDTO dto) {
        Employee e = new Employee();
        e.setId(dto.getId());  // Lấy id từ frontend
        updateEntity(dto, e);
        return e;
    }

    public void updateEntity(EmployeeDetailDTO dto, Employee e) {
        e.setFullName(dto.getFullName());
        e.setGender(dto.getGender());
        e.setBirthDay(dto.getBirthDay());
        e.setDepartment(dto.getDepartment());
        e.setBankAccount(dto.getBankAccount());
        e.setBank(dto.getBank());
        e.setSin(dto.getSin());
        e.setPtin(dto.getPtin());
        e.setNationalId(dto.getNationalId());
        e.setAddress(dto.getAddress());
        e.setPhoneNo(dto.getPhoneNo());
        e.setZaloNo(dto.getZaloNo());
        e.setEmail(dto.getEmail());
        e.setHobby(dto.getHobby());
        e.setFavoriteSport(dto.getFavoriteSport());
        e.setMaritalStatus(dto.getMaritalStatus());
        e.setDateIn(dto.getDateIn());
        e.setSpecialization(dto.getSpecialization());
    }

    /* ========= ENTITY -> DTO ========= */

    public EmployeeDetailDTO toDetailDTO(Employee e) {
        EmployeeDetailDTO dto = new EmployeeDetailDTO();
        dto.setId(e.getId());
        dto.setFullName(e.getFullName());
        dto.setGender(e.getGender());
        dto.setBirthDay(e.getBirthDay());
        dto.setDepartment(e.getDepartment());
        dto.setBankAccount(e.getBankAccount());
        dto.setBank(e.getBank());
        dto.setSin(e.getSin());
        dto.setPtin(e.getPtin());
        dto.setNationalId(e.getNationalId());
        dto.setAddress(e.getAddress());
        dto.setPhoneNo(e.getPhoneNo());
        dto.setZaloNo(e.getZaloNo());
        dto.setEmail(e.getEmail());
        dto.setHobby(e.getHobby());
        dto.setFavoriteSport(e.getFavoriteSport());
        dto.setMaritalStatus(e.getMaritalStatus());
        dto.setDateIn(e.getDateIn());
        dto.setSpecialization(e.getSpecialization());
        dto.setImage(e.getImage());
        dto.setCreatedAt(e.getCreatedAt());
        dto.setUpdatedAt(e.getUpdatedAt());
        return dto;
    }

    public EmployeeListDTO toListDTO(Employee e) {
        EmployeeListDTO dto = new EmployeeListDTO();
        dto.setId(e.getId());
        dto.setFullName(e.getFullName());
        dto.setGender(e.getGender());
        dto.setBirthDay(e.getBirthDay());
        dto.setDepartment(e.getDepartment());
        dto.setBankAccount(e.getBankAccount());
        dto.setSin(e.getSin());
        dto.setPtin(e.getPtin());
        return dto;
    }
}
