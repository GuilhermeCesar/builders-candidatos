package io.platformbuilders.cliente.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.platformbuilders.cliente.enumeration.Sexo;
import io.platformbuilders.cliente.utils.serializer.LocalDateSerializer;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

import static io.platformbuilders.cliente.utils.CalculaIdadeUtils.calculaIdade;

@With
@Jacksonized
public record ClienteDTO(Integer id,
                         String nome,
                         String cpf,
                         @JsonSerialize(using = LocalDateSerializer.class) LocalDate dataNascimento,
                         Sexo sexo) {

    public Integer getIdade() {
        return calculaIdade(this.dataNascimento);
    }
}
