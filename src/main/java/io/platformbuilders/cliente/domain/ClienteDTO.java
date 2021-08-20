package io.platformbuilders.cliente.domain;

import io.platformbuilders.cliente.domain.enumeration.Sexo;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
@With
@Jacksonized
@Builder
@ToString
public class ClienteDTO {

    @NotEmpty
    String nome;
    @NotEmpty
    String cpf;
    @NotNull
    LocalDate dataNascimento;
    @NotNull
    Sexo sexo;
}
