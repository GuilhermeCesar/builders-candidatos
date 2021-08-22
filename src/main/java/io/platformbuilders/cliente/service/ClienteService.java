package io.platformbuilders.cliente.service;

import io.platformbuilders.cliente.dto.ClientSearchDTO;
import io.platformbuilders.cliente.dto.ClienteDTO;
import io.platformbuilders.cliente.dto.ClienteRequestDTO;
import io.platformbuilders.cliente.entity.Cliente;
import io.platformbuilders.cliente.exception.ServiceException;
import io.platformbuilders.cliente.helper.MessageHelper;
import io.platformbuilders.cliente.repository.ClienteRepository;
import io.platformbuilders.cliente.repository.ClienteSpec;
import io.platformbuilders.cliente.utils.mapper.ClienteMapper;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static io.platformbuilders.cliente.helper.ErrorCodeEnum.ERROR_NOT_FOUND;
import static java.util.Optional.ofNullable;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
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
        var clienteBanco = getCliente(id);

        return Try.of(() -> this.clienteMapper
                        .converterClienteRequestDTOparaCliente(clienteBanco, clienteRequestDTO))
                .map(this.clienteRepository::save)
                .map(this.clienteMapper::coverterClienteparaClienteDTO)
                .get();
    }

    public ClienteDTO buscar(Long clienteId) {
        var clienteBanco = getCliente(clienteId);
        return this.clienteMapper
                .coverterClienteparaClienteDTO(clienteBanco);
    }

    private Cliente getCliente(Long clienteId) {
        return this.clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ServiceException(NOT_FOUND,
                        this.messageHelper.get(ERROR_NOT_FOUND, clienteId)
                ));
    }

    public Page<ClienteDTO> buscar(ClientSearchDTO clientSearchDTO, Pageable pageable) {
        var clientSpec = ClienteSpec
                .builder()
                .sexoOptional(ofNullable(clientSearchDTO.sexo()))
                .cpfOptional(ofNullable(clientSearchDTO.cpf()))
                .dataNascimentoOptional(ofNullable(clientSearchDTO.dataNascimento()))
                .idadeOptional(ofNullable(clientSearchDTO.idade()))
                .idOptional(ofNullable(clientSearchDTO.id()))
                .nomeOptional(ofNullable(clientSearchDTO.nome()))
                .build();

        return this.clienteRepository.findAll(clientSpec, pageable)
                .map(this.clienteMapper::coverterClienteparaClienteDTO);
    }
}
