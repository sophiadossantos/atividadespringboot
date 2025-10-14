package com.atividadespringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.atividadespringboot.dto.ClienteDTO;
import com.atividadespringboot.entity.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true) // id gerado pelo banco
    Cliente toEntity(ClienteDTO dto);

    ClienteDTO toDTO(Cliente entity);
}
