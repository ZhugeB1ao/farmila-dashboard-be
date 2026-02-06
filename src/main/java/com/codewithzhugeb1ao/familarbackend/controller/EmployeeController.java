package com.codewithzhugeb1ao.familarbackend.controller;

import com.codewithzhugeb1ao.familarbackend.dto.EmployeeDetailDTO;
import com.codewithzhugeb1ao.familarbackend.dto.EmployeeListDTO;
import com.codewithzhugeb1ao.familarbackend.entity.Employee;
import com.codewithzhugeb1ao.familarbackend.entity.EmploymentContract;
import com.codewithzhugeb1ao.familarbackend.repository.ContractRepository;
import com.codewithzhugeb1ao.familarbackend.repository.EmployeeRepository;
import com.codewithzhugeb1ao.familarbackend.service.EmployeeService;
import com.codewithzhugeb1ao.familarbackend.service.FileStorageService;
import com.codewithzhugeb1ao.familarbackend.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<EmployeeDetailDTO> create(
            @RequestPart("employee") EmployeeDetailDTO dto,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(employeeService.create(dto, image));
    }

    @GetMapping
    public List<EmployeeListDTO> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public EmployeeDetailDTO getById(@PathVariable String id) {
        return employeeService.getById(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public EmployeeDetailDTO update(
            @PathVariable String id,
            @RequestPart("employee") EmployeeDetailDTO dto,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) throws IOException {
        return employeeService.update(id, dto, image);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

