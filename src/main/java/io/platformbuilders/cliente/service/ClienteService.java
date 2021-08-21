package io.platformbuilders.cliente.service;

import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.repository.ClienteRepository;
import io.platformbuilders.cliente.utils.mapper.ClienteMapper;
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
        var cliente = this.clienteMapper.buildCliente(clienteRequestDTO);
        this.clienteRepository.save(cliente);

        var clienteDTO = this.clienteMapper.buildCliente(cliente);
        final var idade = calculaIdade(clienteDTO.dataNascimento());

        return clienteDTO
                .withIdade(idade);
    }

    private Integer calculaIdade(final LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
