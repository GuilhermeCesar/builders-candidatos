package io.platformbuilders.cliente.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Sexo {

    MASCULINO("M"), FEMININO("F"), OUTROS("");

    private final String tipo;


    @JsonValue
    public String getTipo() {
        return this.tipo;
    }
}
