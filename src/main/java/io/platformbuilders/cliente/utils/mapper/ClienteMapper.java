package io.platformbuilders.cliente.utils.mapper;

import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "id", ignore = true)
    Cliente converterClienteRequestDTOparaCliente(ClienteRequestDTO clienteRequestDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "cpf", source = "cpf")
    @Mapping(target = "nome", source = "nome")
    @Mapping(target = "dataNascimento", source = "dataNascimento")
    @Mapping(target = "sexo", source = "sexo")
    ClienteDTO coverterClienteparaClienteDTO(Cliente cliente);

    Cliente converterClienteRequestDTOparaCliente(@MappingTarget Cliente cliente,
                                                  ClienteRequestDTO clienteRequestDTO);
}
