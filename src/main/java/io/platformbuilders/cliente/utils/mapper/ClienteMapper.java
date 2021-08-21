package io.platformbuilders.cliente.utils.mapper;

import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.entity.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {

    public abstract Cliente buildResponsysPushDTO(ClienteRequestDTO clienteRequestDTO);
}
