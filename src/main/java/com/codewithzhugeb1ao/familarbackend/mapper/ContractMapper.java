package com.codewithzhugeb1ao.familarbackend.mapper;

import com.codewithzhugeb1ao.familarbackend.dto.ContractDTO;
import com.codewithzhugeb1ao.familarbackend.entity.EmploymentContract;
import org.springframework.stereotype.Component;

@Component
public class ContractMapper {

    /* ========= ENTITY -> DTO ========= */

    public ContractDTO toDTO(EmploymentContract entity) {
        ContractDTO dto = new ContractDTO();
        dto.setId(entity.getId());
        dto.setContractNo(entity.getContractNo());
        dto.setDurationType(entity.getDurationType());
        dto.setDurationValue(entity.getDurationValue());
        dto.setStartDate(entity.getStartDate());
        dto.setEndDate(entity.getEndDate());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    /* ========= DTO -> ENTITY ========= */

    public EmploymentContract toEntity(ContractDTO dto) {
        EmploymentContract entity = new EmploymentContract();
        updateEntity(dto, entity);
        return entity;
    }

    public void updateEntity(ContractDTO dto, EmploymentContract entity) {
        entity.setContractNo(dto.getContractNo());
        entity.setDurationType(dto.getDurationType());
        entity.setDurationValue(dto.getDurationValue());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());
    }
}
