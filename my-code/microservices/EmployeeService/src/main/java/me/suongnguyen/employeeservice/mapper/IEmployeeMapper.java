package me.suongnguyen.employeeservice.mapper;

import me.suongnguyen.commonmodel.model.employee.EmployeeDto;
import me.suongnguyen.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IEmployeeMapper {
    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);

    Employee toEntity(EmployeeDto dto);

    EmployeeDto toDto(Employee entity);
}