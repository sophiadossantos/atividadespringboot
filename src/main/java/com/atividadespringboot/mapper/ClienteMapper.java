package com.atividadespringboot.mapper;

import com.atividadespringboot.dto.ClienteDTO;
import com.atividadespringboot.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO toDto(Cliente cliente);
    Cliente toEntity(ClienteDTO dto);
}
