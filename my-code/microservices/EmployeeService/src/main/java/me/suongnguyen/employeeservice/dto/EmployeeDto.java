package me.suongnguyen.employeeservice.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class EmployeeDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private DepartmentDto department;
}