package com.atividadespringboot.mapper;

import com.atividadespringboot.dto.TecnicoDTO;
import com.atividadespringboot.entity.Tecnico;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {
    TecnicoMapper INSTANCE = Mappers.getMapper(TecnicoMapper.class);

    TecnicoDTO toDto(Tecnico tecnico);
    Tecnico toEntity(TecnicoDTO dto);
}
