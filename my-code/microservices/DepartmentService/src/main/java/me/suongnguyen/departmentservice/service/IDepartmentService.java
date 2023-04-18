package me.suongnguyen.departmentservice.service;

import me.suongnguyen.departmentservice.dto.DepartmentDto;

public interface IDepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto findByCode(String code);
}
