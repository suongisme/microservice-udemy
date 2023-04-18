package me.suongnguyen.employeeservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.suongnguyen.commonmodel.model.ResponseData;
import me.suongnguyen.employeeservice.clients.department.DepartmentFeign;
import me.suongnguyen.employeeservice.dto.DepartmentDto;
import me.suongnguyen.employeeservice.dto.EmployeeDto;
import me.suongnguyen.employeeservice.entity.Employee;
import me.suongnguyen.employeeservice.mapper.IEmployeeMapper;
import me.suongnguyen.employeeservice.repository.EmployeeRepository;
import me.suongnguyen.employeeservice.service.IEmployeeService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentFeign departmentFeign;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        log.info("create employee: {}", employeeDto);
        Employee employee = IEmployeeMapper.INSTANCE.toEntity(employeeDto);
        Employee savedEmployee = this.employeeRepository.save(employee);
        log.info("create employee successfully");
        return IEmployeeMapper.INSTANCE.toDto(savedEmployee);
    }

    @Override
    public EmployeeDto findById(Long id) {
        log.info("get employee by id: {}", id);
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found employee by id " + id));
        log.info("found employee by id: {}", employee);
        EmployeeDto employeeDto = IEmployeeMapper.INSTANCE.toDto(employee);

        ResponseData<DepartmentDto> responseData = this.departmentFeign.findByCode(employee.getDepartmentCode());
        employeeDto.setDepartment(responseData.getData());
        return employeeDto;
    }
}
