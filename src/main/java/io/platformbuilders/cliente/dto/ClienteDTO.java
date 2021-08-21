package io.platformbuilders.cliente.dto;

import io.platformbuilders.cliente.enumeration.Sexo;
import lombok.Builder;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

@With
@Jacksonized
@Builder
public record ClienteDTO(Integer id,
                         String nome,
                         String cpf,
                         LocalDate dataNascimento,
                         Sexo sexo,
                         Integer idade) {
}
