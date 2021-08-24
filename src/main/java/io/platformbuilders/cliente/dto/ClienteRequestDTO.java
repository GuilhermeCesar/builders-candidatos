package io.platformbuilders.cliente.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.platformbuilders.cliente.enumeration.Sexo;
import io.platformbuilders.cliente.utils.deserializer.CpfDeserializer;
import io.platformbuilders.cliente.utils.deserializer.LocalDateDeserializer;
import io.platformbuilders.cliente.utils.deserializer.SexoDeserializer;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;
import lombok.With;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
@With
@Builder(builderClassName = "JacksonBuilder")
@ToString
@JsonDeserialize(builder = ClienteRequestDTO.JacksonBuilder.class)
public class ClienteRequestDTO {

    @NotEmpty
    String nome;
    @Schema(defaultValue = "318.955.540-04")
    @CPF
    @NotEmpty
    String cpf;
    @NotNull
    @Schema(pattern = "dd/mm/YYYY", description = "dd/mm/YYYY", type = "string", defaultValue = "09/06/1993")
    LocalDate dataNascimento;
    @NotNull
    Sexo sexo;

    @JsonPOJOBuilder(withPrefix = "")
    public static class JacksonBuilder {

        public JacksonBuilder dataNascimento(String dataNascimento) {
            this.dataNascimento = LocalDateDeserializer.localDatePtBr(dataNascimento);
            return this;
        }

        public JacksonBuilder sexo(String sexo) {
            this.sexo = SexoDeserializer.deserialize(sexo);
            return this;
        }

        public JacksonBuilder cpf(String cpf) {
            this.cpf = CpfDeserializer.removerCaractersEspeciais(cpf);
            return this;
        }
    }
}
