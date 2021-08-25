package io.platformbuilders.cliente.service;

import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.entity.Cliente;
import io.platformbuilders.cliente.exception.ServiceException;
import io.platformbuilders.cliente.helper.ErrorCodeEnum;
import io.platformbuilders.cliente.helper.MessageHelper;
import io.platformbuilders.cliente.repository.ClienteRepository;
import io.platformbuilders.cliente.utils.mapper.ClienteMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

import static io.platformbuilders.cliente.enumeration.Sexo.MASCULINO;
import static io.platformbuilders.cliente.utils.CalculaIdadeUtils.calculaIdade;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private MessageHelper messageHelper;
    @Mock
    private ClienteMapper clienteMapper;

    @Test
    void buscarClienteInexistentePorId() {
        final var idCliente = 1L;
        final String erro = "O cliente com id 1 não existe";

        when(this.clienteRepository.findById(idCliente))
                .thenReturn(Optional.empty());
        when(this.messageHelper.get(eq(ErrorCodeEnum.ERROR_NOT_FOUND), any()))
                .thenReturn(erro);

        var serviceException = Assert.assertThrows(ServiceException.class,
                () -> this.clienteService.buscar(idCliente));

        Assertions.assertEquals(NOT_FOUND, serviceException.getStatus());
        Assertions.assertNotNull(serviceException.getMessage());
    }

    @Test
    void buscarClientePorId() {
        final var idCliente = 1L;
        final var cliente = Cliente
                .builder()
                .cpf("21804045063")
                .id(idCliente)
                .dataNascimento(LocalDate.of(2000, 10, 1))
                .nome("Joao")
                .sexo(MASCULINO)
                .build();

        when(this.clienteRepository.findById(idCliente))
                .thenReturn(Optional.of(cliente));

        this.clienteService.buscar(idCliente);

        verify(this.clienteMapper, times(1)).coverterClienteparaClienteDTO(any());
    }

    @Test
    void salvarCliente() {
        final var nome = "Joao";
        final var cpf = "21804045063";
        final var dataNascimento = LocalDate.of(1993, 6, 9);

        final var clienteRequestDTO = ClienteRequestDTO
                .builder()
                .cpf("218.040.450-63")
                .dataNascimento("09/06/1993")
                .nome(nome)
                .sexo("M")
                .build();
        final var clienteDTO = new ClienteDTO(1, nome, cpf, dataNascimento, MASCULINO);
        final var cliente = Cliente
                .builder()
                .sexo(MASCULINO)
                .nome("Guilherme")
                .dataNascimento(dataNascimento)
                .cpf(cpf)
                .id(1L)
                .build();

        final var pattern = Pattern.compile("[\\.\\-]");

        when(this.clienteMapper.converterClienteRequestDTOparaCliente(clienteRequestDTO))
                .thenReturn(cliente);
        when(this.clienteRepository.save(any()))
                .thenReturn(cliente);
        when(this.clienteMapper.coverterClienteparaClienteDTO(any()))
                .thenReturn(clienteDTO);

        final var clienteDTORetornado = this.clienteService.salvar(clienteRequestDTO);

        assertNotNull(clienteDTORetornado.id());
        assertEquals(calculaIdade(dataNascimento), clienteDTORetornado.idade());
        assertEquals(nome, clienteDTORetornado.nome());
        assertFalse(pattern.matcher(clienteDTORetornado.cpf()).matches());
    }
}
