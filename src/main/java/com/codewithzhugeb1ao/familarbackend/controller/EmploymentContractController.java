package com.codewithzhugeb1ao.familarbackend.controller;

import com.codewithzhugeb1ao.familarbackend.dto.ContractDTO;
import com.codewithzhugeb1ao.familarbackend.service.ContractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees/{employeeId}/contracts")
public class EmploymentContractController {

    private final ContractService contractService;

    public EmploymentContractController(ContractService contractService) {
        this.contractService = contractService;
    }

    @GetMapping
    public ResponseEntity<List<ContractDTO>> getAllContracts(
            @PathVariable String employeeId) {
        return ResponseEntity.ok(contractService.getAllByEmployee(employeeId));
    }

    @GetMapping("/active")
    public ResponseEntity<ContractDTO> getActiveContract(
            @PathVariable String employeeId) {
        return ResponseEntity.ok(contractService.getActiveContract(employeeId));
    }
}
