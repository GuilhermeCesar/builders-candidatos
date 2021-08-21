package io.platformbuilders.cliente.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Sexo {

    MASCULINO("M"), FEMININO("F"), OUTROS("");

    private final String tipo;
}
