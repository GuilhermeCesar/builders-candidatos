package io.platformbuilders.cliente.resource.v1;

import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.dto.ClienteSearchDTO;
import io.platformbuilders.cliente.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "Clientes")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/clientes", produces = APPLICATION_JSON_VALUE)
public class ClienteResource {

    private final ClienteService clienteService;

    @Operation(summary = "Create client",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = ClienteDTO.class)))}
    )
    @PostMapping
    @ResponseStatus(CREATED)
    public ClienteDTO criarCliente(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        return this.clienteService.salvar(clienteRequestDTO);
    }

    @Operation(summary = "Update client by id",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ClienteDTO.class)))})
    @PutMapping("/{clienteId}")
    @ResponseStatus(OK)
    public ClienteDTO atualizarCliente(@PathVariable("clienteId") Long clienteId,
                                       @Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        return this.clienteService.atualizar(clienteId, clienteRequestDTO);
    }

    @Operation(summary = "Get clients",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ClienteDTO.class)))}
    )
    @GetMapping("/{clienteId}")
    @ResponseStatus(OK)
    public ClienteDTO getCliente(@PathVariable("clienteId") Long clienteId) {
        return this.clienteService.buscar(clienteId);
    }

    @Operation(summary = "Get clients",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Page.class)))}
    )
    @GetMapping
    @ResponseStatus(OK)
    public Page<ClienteDTO> getCliente(ClienteSearchDTO clienteDTO, Pageable pageable) {
        return this.clienteService.buscar(clienteDTO, pageable);
    }
}
