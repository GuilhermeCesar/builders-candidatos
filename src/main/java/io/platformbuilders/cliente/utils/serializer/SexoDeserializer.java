package io.platformbuilders.cliente.utils.serializer;

import io.platformbuilders.cliente.enumeration.Sexo;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@NoArgsConstructor
@Slf4j
public class SexoDeserializer {

    public static Sexo deserialize(String sexo) {
        for (Sexo tipoOperacaoEnum : Sexo.values()) {
            if (tipoOperacaoEnum.getTipo().equals(sexo)) {
                return tipoOperacaoEnum;
            }
        }
        return Sexo.OUTROS;
    }
}