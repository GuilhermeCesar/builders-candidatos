package io.platformbuilders.cliente.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.platformbuilders.cliente.enumeration.Sexo;
import io.platformbuilders.cliente.utils.serializer.LocalDateSerializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

import static io.platformbuilders.cliente.utils.CalculaIdadeUtils.calculaIdade;

@Builder
@With
@Jacksonized
public record ClienteDTO(Integer id,
                         String nome,
                         String cpf,
                         @Schema(pattern = "dd/mm/YYYY", description = "dd/mm/YYYY", type = "string", defaultValue = "09/06/1993")
                         @JsonSerialize(using = LocalDateSerializer.class) LocalDate dataNascimento,
                         Sexo sexo) {

    public Integer idade() {
        return calculaIdade(this.dataNascimento);
    }
}
