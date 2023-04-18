package me.suongnguyen.departmentservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.suongnguyen.departmentservice.dto.DepartmentDto;
import me.suongnguyen.departmentservice.entity.Department;
import me.suongnguyen.departmentservice.mapper.IDepartmentMapper;
import me.suongnguyen.departmentservice.repository.DepartmentRepository;
import me.suongnguyen.departmentservice.service.IDepartmentService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements IDepartmentService {

    private final DepartmentRepository departmentRepository;

    @Transactional
    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        log.info("create department: {}", departmentDto);
        Department department = IDepartmentMapper.INSTANCE.toEntity(departmentDto);
        Department savedDepartment = this.departmentRepository.save(department);
        log.info("create department successfully");
        return IDepartmentMapper.INSTANCE.toDto(savedDepartment);
    }

    @Override
    public DepartmentDto findByCode(String code) {
        log.info("get department by code: {}", code);
        Department department = this.departmentRepository.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("not found department by code: " + code));
        log.info("found department by code: {}", department);
        return IDepartmentMapper.INSTANCE.toDto(department);
    }
}
