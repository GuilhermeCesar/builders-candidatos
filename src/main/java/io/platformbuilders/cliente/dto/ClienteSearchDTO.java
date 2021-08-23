package io.platformbuilders.cliente.dto;

import io.platformbuilders.cliente.enumeration.Sexo;

import java.time.LocalDate;

public record ClienteSearchDTO(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        Sexo sexo,
        Integer idade) {
}
