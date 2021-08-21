package io.platformbuilders.cliente.service;

import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.utils.mapper.ClienteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteMapper clienteMapper;

    public ClienteDTO persist(ClienteRequestDTO clienteRequestDTO){
        var cliente = clienteMapper.buildResponsysPushDTO(clienteRequestDTO);
        return null;
    }
}
