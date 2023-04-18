package me.suongnguyen.employeeservice.clients.department;

import me.suongnguyen.commonmodel.model.ResponseData;
import me.suongnguyen.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentFeign {

    @GetMapping(path = "/api/departments", params = {"code"})
    ResponseData<DepartmentDto> findByCode(@RequestParam String code);
}
