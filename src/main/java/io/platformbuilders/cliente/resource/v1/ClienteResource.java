package io.platformbuilders.cliente.resource.v1;

import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.dto.ClienteSearchDTO;
import io.platformbuilders.cliente.enumeration.Sexo;
import io.platformbuilders.cliente.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;

import static io.platformbuilders.cliente.config.SpringDocConfig.SwaggerTags.CLIENTE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = CLIENTE)
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/v1/clientes", produces = APPLICATION_JSON_VALUE)
public class ClienteResource {

    private final ClienteService clienteService;

    @Operation(summary = "Criar clientes",
            responses = {@ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = ClienteDTO.class)))}
    )
    @PostMapping
    @ResponseStatus(CREATED)
    public ClienteDTO criarCliente(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        return this.clienteService.salvar(clienteRequestDTO);
    }

    @Operation(summary = "Atualizar clientes",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ClienteDTO.class)))})
    @PutMapping("/{clienteId}")
    @ResponseStatus(OK)
    public ClienteDTO atualizarCliente(@PathVariable("clienteId") Long clienteId,
                                       @Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        return this.clienteService.atualizar(clienteId, clienteRequestDTO);
    }

    @Operation(summary = "Get client by id",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = ClienteDTO.class)))}
    )
    @GetMapping("/{clienteId}")
    @ResponseStatus(OK)
    public ClienteDTO getCliente(@PathVariable("clienteId") Long clienteId) {
        return this.clienteService.buscar(clienteId);
    }

    @Operation(summary = "Find by filter",
            responses = {@ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = Page.class)))}
    )
    @GetMapping
    @ResponseStatus(OK)
    public Page<ClienteDTO> getCliente(@RequestParam(name = "id", required = false) Long id,
                                       @RequestParam(name = "nome", required = false) String nome,
                                       @RequestParam(name = "cpf", required = false) String cpf,
                                       @RequestParam(name = "dataNascimento", required = false) LocalDate dataNascimento,
                                       @RequestParam(name = "sexo", required = false) Sexo sexo,
                                       @RequestParam(name = "idade", required = false) Integer idade,
                                       @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                       @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {

        final var clienteDTO = new ClienteSearchDTO(id, nome, cpf, dataNascimento, sexo, idade);
        return this.clienteService.buscar(clienteDTO, PageRequest.of(page, size, Sort.by(Sort.Order.desc("id"))));
    }
}
