package me.suongnguyen.commonmodel.model.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.suongnguyen.commonmodel.model.department.DepartmentDto;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private DepartmentDto department;
}