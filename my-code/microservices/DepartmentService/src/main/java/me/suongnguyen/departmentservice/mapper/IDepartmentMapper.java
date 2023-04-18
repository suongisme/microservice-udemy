package me.suongnguyen.departmentservice.mapper;

import me.suongnguyen.commonmodel.mapper.IMapper;
import me.suongnguyen.departmentservice.dto.DepartmentDto;
import me.suongnguyen.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IDepartmentMapper extends IMapper<Department, DepartmentDto> {
    IDepartmentMapper INSTANCE = Mappers.getMapper(IDepartmentMapper.class);
}
