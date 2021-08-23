package io.platformbuilders.cliente.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.platformbuilders.cliente.enumeration.Sexo;
import io.platformbuilders.cliente.utils.serializer.LocalDateSerializer;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDate;

import static io.platformbuilders.cliente.utils.CalculaIdadeUtils.calculaIdade;

@Value
@With
@Jacksonized
@Builder
@ToString
public class ClienteDTO {

    Integer id;
    String nome;
    String cpf;
    @JsonSerialize(using = LocalDateSerializer.class)
    LocalDate dataNascimento;
    Sexo sexo;
    Integer idade;

    public Integer getIdade() {
        return calculaIdade(dataNascimento);
    }
}
