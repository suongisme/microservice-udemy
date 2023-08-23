package me.suongnguyen.employeeservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.suongnguyen.commonmodel.constant.ValidationError;
import me.suongnguyen.commonmodel.exception.BusinessException;
import me.suongnguyen.commonmodel.model.common.ResponseData;
import me.suongnguyen.commonmodel.model.department.DepartmentDto;
import me.suongnguyen.commonmodel.model.employee.EmployeeDto;
import me.suongnguyen.commonmodel.model.employee.request.CreateEmployeeReq;
import me.suongnguyen.employeeservice.clients.department.DepartmentFeign;
import me.suongnguyen.employeeservice.entity.Employee;
import me.suongnguyen.employeeservice.mapper.IEmployeeMapper;
import me.suongnguyen.employeeservice.repository.EmployeeRepository;
import me.suongnguyen.employeeservice.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentFeign departmentFeign;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public EmployeeDto createEmployee(CreateEmployeeReq employeeDto) {
        log.info("create employee: {}", employeeDto);
        Optional<Employee> byEmail = this.employeeRepository.findByEmail(employeeDto.getEmail());
        if (byEmail.isPresent()) {
            throw new BusinessException(ValidationError.DATA_EXIST, "Employee", employeeDto.getEmail());
        }
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
