package io.platformbuilders.cliente.service;

import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.repository.ClienteRepository;
import io.platformbuilders.cliente.utils.mapper.ClienteMapper;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    public ClienteDTO salvar(final ClienteRequestDTO clienteRequestDTO) {
        return Try.of(() -> this.clienteMapper.converterClienteRequestDTOparaCliente(clienteRequestDTO))
                .map(this.clienteRepository::save)
                .map(this.clienteMapper::coverterClienteparaClienteDTO)
                .map(this::calculaIdade)
                .get();
    }

    private ClienteDTO calculaIdade(ClienteDTO clienteDTO) {
        final var idade = Period.between(clienteDTO.dataNascimento(), LocalDate.now()).getYears();
        return clienteDTO.withIdade(idade);
    }
}
