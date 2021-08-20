package io.platformbuilders.cliente.resource.v1;

import io.platformbuilders.cliente.domain.ClienteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/candidato", produces = APPLICATION_JSON_VALUE)
public class CandidatosResource {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String criarClient( @RequestBody ClienteDTO clienteDTO) {
        return "Pegati";
    }
}
