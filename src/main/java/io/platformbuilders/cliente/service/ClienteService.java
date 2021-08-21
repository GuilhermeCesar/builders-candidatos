package io.platformbuilders.cliente.service;

import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.exception.ServiceException;
import io.platformbuilders.cliente.helper.MessageHelper;
import io.platformbuilders.cliente.repository.ClienteRepository;
import io.platformbuilders.cliente.utils.mapper.ClienteMapper;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static io.platformbuilders.cliente.helper.ErrorCodeEnum.ERROR_NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;
    private final MessageHelper messageHelper;

    public ClienteDTO salvar(final ClienteRequestDTO clienteRequestDTO) {
        return Try.of(() -> this.clienteMapper.converterClienteRequestDTOparaCliente(clienteRequestDTO))
                .map(this.clienteRepository::save)
                .map(this.clienteMapper::coverterClienteparaClienteDTO)
                .get();
    }

    public ClienteDTO atualizar(final Long id, final ClienteRequestDTO clienteRequestDTO) {
        var clienteBanco = this.clienteRepository.findById(id)
                .orElseThrow(() -> new ServiceException(NOT_FOUND,
                        this.messageHelper.get(ERROR_NOT_FOUND, id)
                ));

        return Try.of(() -> this.clienteMapper
                        .converterClienteRequestDTOparaCliente(clienteBanco, clienteRequestDTO))
                .map(this.clienteRepository::save)
                .map(this.clienteMapper::coverterClienteparaClienteDTO)
                .get();
    }
}
