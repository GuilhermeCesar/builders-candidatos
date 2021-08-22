package io.platformbuilders.cliente.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.platformbuilders.cliente.enumeration.Sexo;
import io.platformbuilders.cliente.utils.deserializer.CpfDeserializer;
import io.platformbuilders.cliente.utils.deserializer.LocalDateDeserializer;
import io.platformbuilders.cliente.utils.deserializer.SexoDeserializer;
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
    @CPF
    @NotEmpty
    String cpf;
    @NotNull
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
