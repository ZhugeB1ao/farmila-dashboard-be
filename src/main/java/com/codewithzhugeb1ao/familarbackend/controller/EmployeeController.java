package com.codewithzhugeb1ao.familarbackend.controller;

import com.codewithzhugeb1ao.familarbackend.dto.EmployeeDTO;
import com.codewithzhugeb1ao.familarbackend.entity.Employee;
import com.codewithzhugeb1ao.familarbackend.repository.EmployeeRepository;
import com.codewithzhugeb1ao.familarbackend.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private FileStorageService fileStorageService;

    /**
     * Tạo employee mới với ảnh
     * Frontend gửi: multipart/form-data với 2 phần:
     * - "employee": JSON string của EmployeeDTO
     * - "image": file ảnh (optional)
     */
    @PostMapping(value = "/employee", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Employee> createEmployee(
            @RequestPart("employee") EmployeeDTO employeeDTO,
            @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {

        Employee employee = new Employee();

        // Generate UUID cho employee mới
        employee.setId(UUID.randomUUID().toString());

        // Copy các field từ DTO sang Entity
        mapDtoToEntity(employeeDTO, employee);

        // Xử lý upload ảnh
        if (image != null && !image.isEmpty()) {
            String imageUrl = fileStorageService.storeFile(image);
            employee.setImage(imageUrl);
        }

        // Set timestamps
        employee.setCreatedAt(Instant.now());
        employee.setUpdatedAt(Instant.now());

        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    /**
     * Lấy tất cả employees
     */
    @GetMapping("/employees")
    public ResponseEntity<Iterable<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    /**
     * Lấy employee theo ID
     */
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id - " + id));
        return ResponseEntity.ok(employee);
    }

    /**
     * Cập nhật employee với ảnh mới (optional)
     * Nếu có ảnh mới, xóa ảnh cũ và lưu ảnh mới
     */
    @PutMapping(value = "/employee/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable String id,
            @RequestPart("employee") EmployeeDTO employeeDTO,
            @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id - " + id));

        // Copy các field từ DTO sang Entity
        mapDtoToEntity(employeeDTO, existingEmployee);

        // Xử lý upload ảnh mới
        if (image != null && !image.isEmpty()) {
            // Xóa ảnh cũ
            fileStorageService.deleteFile(existingEmployee.getImage());

            // Lưu ảnh mới
            String imageUrl = fileStorageService.storeFile(image);
            existingEmployee.setImage(imageUrl);
        }

        // Update timestamp
        existingEmployee.setUpdatedAt(Instant.now());

        Employee savedEmployee = employeeRepository.save(existingEmployee);
        return ResponseEntity.ok(savedEmployee);
    }

    /**
     * Xóa employee và ảnh liên quan
     */
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id - " + id));

        // Xóa ảnh
        fileStorageService.deleteFile(employee.getImage());

        // Xóa employee
        employeeRepository.delete(employee);

        return ResponseEntity.noContent().build();
    }

    /**
     * Helper method để map DTO sang Entity
     */
    private void mapDtoToEntity(EmployeeDTO dto, Employee entity) {
        entity.setFullName(dto.getFullName());
        entity.setGender(dto.getGender());
        entity.setBirthDay(dto.getBirthDay());
        entity.setDepartment(dto.getDepartment());
        entity.setBankAccount(dto.getBankAccount());
        entity.setBank(dto.getBank());
        entity.setSin(dto.getSin());
        entity.setPtin(dto.getPtin());
        entity.setNationalId(dto.getNationalId());
        entity.setAddress(dto.getAddress());
        entity.setPhoneNo(dto.getPhoneNo());
        entity.setZaloNo(dto.getZaloNo());
        entity.setEmail(dto.getEmail());
        entity.setHobby(dto.getHobby());
        entity.setFavoriteSport(dto.getFavoriteSport());
        entity.setMaritalStatus(dto.getMaritalStatus());
        entity.setDateIn(dto.getDateIn());
        entity.setSpecialization(dto.getSpecialization());
    }
}
