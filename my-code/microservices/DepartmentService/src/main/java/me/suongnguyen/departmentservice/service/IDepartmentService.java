package me.suongnguyen.departmentservice.service;

import me.suongnguyen.commonmodel.model.department.DepartmentDto;

public interface IDepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto findByCode(String code);
}
