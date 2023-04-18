package me.suongnguyen.departmentservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentDto {
    private Long id;
    private String name;
    private String code;
    private String description;
}
