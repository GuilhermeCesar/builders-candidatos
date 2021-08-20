package io.platformbuilders.cliente.domain;

import io.platformbuilders.cliente.domain.enumeration.Sexo;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@Value
@With
@Jacksonized
@Builder
@ToString
public class ClienteDTO {

    String nome;
    String socialId;
    LocalDate dataNascimento;
    Sexo sexo;
}
