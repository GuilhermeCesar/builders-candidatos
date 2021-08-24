package io.platformbuilders.cliente.service;

import io.platformbuilders.cliente.exception.ServiceException;
import io.platformbuilders.cliente.helper.ErrorCodeEnum;
import io.platformbuilders.cliente.helper.MessageHelper;
import io.platformbuilders.cliente.repository.ClienteRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private MessageHelper messageHelper;

    @Test
    public void buscarClienteInexistente() {
        final var idCliente = 1L;
        final String erro = "O cliente com id 1 não existe";

        when(this.clienteRepository.findById(idCliente))
                .thenReturn(Optional.empty());
        when(this.messageHelper.get(eq(ErrorCodeEnum.ERROR_NOT_FOUND), any()))
                .thenReturn(erro);

        var serviceException = Assert.assertThrows(ServiceException.class,
                () -> this.clienteService.buscar(idCliente));

        Assert.assertEquals(HttpStatus.NOT_FOUND, serviceException.getStatus());
        Assert.assertNotNull(serviceException.getMessage());
    }
}
