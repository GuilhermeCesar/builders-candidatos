package io.platformbuilders.cliente.dto;

import io.platformbuilders.cliente.enumeration.Sexo;
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

    Integer id;
    String nome;
    String cpf;
    LocalDate dataNascimento;
    Sexo sexo;
    Integer idade;
}
