package io.platformbuilders.cliente.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.platformbuilders.cliente.enumeration.Sexo;
import io.platformbuilders.cliente.utils.deserializer.LocalDateDeserializer;

import java.time.LocalDate;

public record ClientSearchDTO(
        Long id,
        String nome,
        String cpf,
        @JsonDeserialize(using = LocalDateDeserializer.class) LocalDate dataNascimento,
        Sexo sexo,
        Integer idade) {


}
