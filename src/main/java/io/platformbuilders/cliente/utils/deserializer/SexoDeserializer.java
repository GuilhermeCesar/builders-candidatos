package io.platformbuilders.cliente.utils.deserializer;

import io.platformbuilders.cliente.enumeration.Sexo;

import static io.platformbuilders.cliente.enumeration.Sexo.OUTROS;

public class SexoDeserializer {

    private SexoDeserializer() {
    }

    public static Sexo deserialize(String sexo) {
        for (Sexo tipoOperacaoEnum : Sexo.values()) {
            if (tipoOperacaoEnum.getTipo().equals(sexo)) {
                return tipoOperacaoEnum;
            }
        }
        return OUTROS;
    }
}