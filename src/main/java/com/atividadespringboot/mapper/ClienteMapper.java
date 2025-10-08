package com.atividadespringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.atividadespringboot.entity.Cliente;
import com.atividadespringboot.dto.ClienteDTO;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    ClienteDTO toDTO(Cliente cliente);
    Cliente toEntity(ClienteDTO dto);
}
