package me.suongnguyen.employeeservice.service;

import me.suongnguyen.employeeservice.dto.EmployeeDto;

public interface IEmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto findById(Long id);
}
