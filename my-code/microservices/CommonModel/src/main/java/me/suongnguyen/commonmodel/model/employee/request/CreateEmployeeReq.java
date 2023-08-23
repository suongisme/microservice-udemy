package me.suongnguyen.commonmodel.model.employee.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import me.suongnguyen.commonmodel.model.department.DepartmentDto;
import me.suongnguyen.commonmodel.model.employee.EmployeeDto;

public class CreateEmployeeReq extends EmployeeDto {

    @NotBlank(message = "employee.required.first-name")
    @Size(max = 100, message = "employee.max-length.first-name")
    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @NotBlank(message = "employee.required.last-name")
    @Size(max = 100, message = "employee.max-length.last-name")
    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @NotBlank(message = "employee.required.name")
    @Size(max = 100, message = "employee.max-length.name")
    @Email(message = "employee.invalid.email")
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @NotBlank(message = "employee.required.department-code")
    public String departmentCode;

    @JsonIgnore
    @Override
    public DepartmentDto getDepartment() {
        return super.getDepartment();
    }
}
