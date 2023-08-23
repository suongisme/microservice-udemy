package me.suongnguyen.departmentservice.controller;

import lombok.RequiredArgsConstructor;
import me.suongnguyen.commonmodel.model.common.ResponseData;
import me.suongnguyen.commonmodel.model.department.DepartmentDto;
import me.suongnguyen.departmentservice.service.IDepartmentService;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final IDepartmentService departmentService;

    @GetMapping(params = {"code"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseData<DepartmentDto> findByCode(@RequestParam String code) {
        return ResponseData.success(this.departmentService.findByCode(code));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        return ResponseData.success(this.departmentService.createDepartment(departmentDto));
    }
}
