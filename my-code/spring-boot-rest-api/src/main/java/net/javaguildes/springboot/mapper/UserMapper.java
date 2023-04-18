package net.javaguildes.springboot.mapper;

import net.javaguildes.springboot.dto.UserDTO;
import net.javaguildes.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);

    void copyPropertiesNotNull(UserDTO source, @MappingTarget() UserDTO target);

}
