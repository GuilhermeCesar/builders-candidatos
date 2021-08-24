package io.platformbuilders.cliente.service;

import io.platformbuilders.cliente.entity.Cliente;
import io.platformbuilders.cliente.enumeration.Sexo;
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
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        Assertions.assertEquals(HttpStatus.NOT_FOUND, serviceException.getStatus());
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
                .sexo(Sexo.MASCULINO)
                .build();

        when(this.clienteRepository.findById(idCliente))
                .thenReturn(Optional.of(cliente));

        this.clienteService.buscar(idCliente);

        verify(this.clienteMapper, times(1)).coverterClienteparaClienteDTO(any());
    }
}
