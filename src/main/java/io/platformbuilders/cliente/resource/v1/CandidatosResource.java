package io.platformbuilders.cliente.resource.v1;

import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/clientes", produces = APPLICATION_JSON_VALUE)
public class CandidatosResource {

    private final ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ClienteDTO criarClient(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        return this.clienteService.persist(clienteRequestDTO);
    }
}
