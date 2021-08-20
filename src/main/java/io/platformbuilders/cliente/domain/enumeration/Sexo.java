package io.platformbuilders.cliente.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Sexo {

    MASCULINO("M"), FEMININO("F"), OUTROS("");

    private final String tipo;
}
