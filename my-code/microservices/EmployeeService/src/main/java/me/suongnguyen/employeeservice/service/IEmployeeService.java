package me.suongnguyen.employeeservice.service;

import me.suongnguyen.commonmodel.model.employee.EmployeeDto;
import me.suongnguyen.commonmodel.model.employee.request.CreateEmployeeReq;

public interface IEmployeeService {

    EmployeeDto createEmployee(CreateEmployeeReq employeeDto);

    EmployeeDto findById(Long id);
}
