package me.suongnguyen.commonmodel.mapper;

public interface IMapper<ENTITY, DTO> {
    ENTITY toEntity(DTO dto);

    DTO toDto(ENTITY entity);
}
