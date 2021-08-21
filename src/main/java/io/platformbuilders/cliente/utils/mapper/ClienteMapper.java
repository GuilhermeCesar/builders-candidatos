package io.platformbuilders.cliente.utils.mapper;

import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente converterClienteRequestDTOparaCliente(ClienteRequestDTO clienteRequestDTO);

    ClienteDTO coverterClienteparaClienteDTO(Cliente cliente);

    Cliente converterClienteRequestDTOparaCliente(@MappingTarget Cliente cliente,
                                                  ClienteRequestDTO clienteRequestDTO);
}
