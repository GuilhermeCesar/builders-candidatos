package io.platformbuilders.cliente.utils.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import io.platformbuilders.cliente.enumeration.Sexo;

import java.io.IOException;

import static io.platformbuilders.cliente.enumeration.Sexo.OUTROS;

public class SexoDeserializer extends StdDeserializer<Sexo> {

    public SexoDeserializer() {
        this(Sexo.class);
    }

    public SexoDeserializer(Class<Sexo> t) {
        super(t);
    }

    public static Sexo deserialize(String sexo) {
        for (Sexo tipoOperacaoEnum : Sexo.values()) {
            if (tipoOperacaoEnum.getTipo().equals(sexo)) {
                return tipoOperacaoEnum;
            }
        }
        return OUTROS;
    }

    @Override
    public Sexo deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return SexoDeserializer.deserialize(p.getText());
    }
}