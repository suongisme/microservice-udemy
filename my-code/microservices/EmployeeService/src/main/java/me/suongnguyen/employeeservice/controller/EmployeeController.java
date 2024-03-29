package me.suongnguyen.employeeservice.controller;

import lombok.RequiredArgsConstructor;
import me.suongnguyen.commonmodel.model.common.ResponseData;
import me.suongnguyen.commonmodel.model.employee.EmployeeDto;
import me.suongnguyen.commonmodel.model.employee.request.CreateEmployeeReq;
import me.suongnguyen.employeeservice.service.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseData<EmployeeDto> findById(@PathVariable Long id) {
        return ResponseData.success(this.employeeService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<EmployeeDto> createEmployee(@RequestBody @Validated CreateEmployeeReq employeeDto) {
        return ResponseData.success(this.employeeService.createEmployee(employeeDto));
    }
}
