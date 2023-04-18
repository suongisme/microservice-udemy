package me.suongnguyen.employeeservice.mapper;

import me.suongnguyen.commonmodel.mapper.IMapper;
import me.suongnguyen.employeeservice.dto.EmployeeDto;
import me.suongnguyen.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IEmployeeMapper extends IMapper<Employee, EmployeeDto> {
    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);
}