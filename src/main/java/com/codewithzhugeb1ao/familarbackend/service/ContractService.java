package com.codewithzhugeb1ao.familarbackend.service;

import com.codewithzhugeb1ao.familarbackend.dto.ContractDTO;
import com.codewithzhugeb1ao.familarbackend.mapper.ContractMapper;
import com.codewithzhugeb1ao.familarbackend.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final ContractMapper contractMapper;

    public ContractService(ContractRepository contractRepository,
                           ContractMapper contractMapper) {
        this.contractRepository = contractRepository;
        this.contractMapper = contractMapper;
    }

    public List<ContractDTO> getAllByEmployee(String employeeId) {
        return contractRepository.findByEmployeeId(employeeId)
                .stream()
                .map(contractMapper::toDTO)
                .toList();
    }

    public ContractDTO getActiveContract(String employeeId) {
        return contractRepository.findActiveContract(employeeId)
                .map(contractMapper::toDTO)
                .orElse(null);
    }
}
