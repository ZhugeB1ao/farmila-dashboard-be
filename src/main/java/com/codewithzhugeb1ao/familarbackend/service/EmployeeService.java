package com.codewithzhugeb1ao.familarbackend.service;

import com.codewithzhugeb1ao.familarbackend.dto.EmployeeDetailDTO;
import com.codewithzhugeb1ao.familarbackend.dto.EmployeeListDTO;
import com.codewithzhugeb1ao.familarbackend.entity.Employee;
import com.codewithzhugeb1ao.familarbackend.mapper.EmployeeMapper;
import com.codewithzhugeb1ao.familarbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final FileStorageService fileStorageService;

    public EmployeeService(EmployeeRepository employeeRepository,
                           EmployeeMapper employeeMapper,
                           FileStorageService fileStorageService) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
        this.fileStorageService = fileStorageService;
    }

    /* ========= CREATE ========= */

    public EmployeeDetailDTO create(EmployeeDetailDTO dto, MultipartFile image) throws IOException {
        Employee employee = employeeMapper.toEntity(dto);

        employee.setCreatedAt(Instant.now());
        employee.setUpdatedAt(Instant.now());

        // Bước 1: Lưu employee vào database TRƯỚC (chưa có ảnh)
        Employee savedEmployee = employeeRepository.save(employee);

        // Bước 2: Nếu lưu thành công, mới lưu ảnh
        if (image != null && !image.isEmpty()) {
            try {
                String imagePath = fileStorageService.storeFile(image);
                savedEmployee.setImage(imagePath);
                savedEmployee = employeeRepository.save(savedEmployee);
            } catch (IOException e) {
                // Nếu lưu ảnh thất bại, xóa employee đã tạo để rollback
                employeeRepository.delete(savedEmployee);
                throw new IOException("Lưu ảnh thất bại, đã rollback employee: " + e.getMessage());
            }
        }

        return employeeMapper.toDetailDTO(savedEmployee);
    }

    /* ========= READ ========= */

    public List<EmployeeListDTO> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toListDTO)
                .toList();
    }

    public EmployeeDetailDTO getById(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        return employeeMapper.toDetailDTO(employee);
    }

    /* ========= UPDATE ========= */

    public EmployeeDetailDTO update(String id, EmployeeDetailDTO dto, MultipartFile image)
            throws IOException {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employeeMapper.updateEntity(dto, employee);

        if (image != null && !image.isEmpty()) {
            fileStorageService.deleteFile(employee.getImage());
            employee.setImage(fileStorageService.storeFile(image));
        }

        employee.setUpdatedAt(Instant.now());
        return employeeMapper.toDetailDTO(employeeRepository.save(employee));
    }

    /* ========= DELETE ========= */

    public void delete(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        fileStorageService.deleteFile(employee.getImage());
        employeeRepository.delete(employee);
    }
}
