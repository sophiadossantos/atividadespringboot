package com.atividadespringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.atividadespringboot.dto.TecnicoDTO;
import com.atividadespringboot.entity.Tecnico;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {

    @Mapping(target = "id", ignore = true) // id gerado pelo banco
    Tecnico toEntity(TecnicoDTO dto);

    TecnicoDTO toDTO(Tecnico entity);
}
