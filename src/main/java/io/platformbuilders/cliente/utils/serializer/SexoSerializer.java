package io.platformbuilders.cliente.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import io.platformbuilders.cliente.enumeration.Sexo;
import lombok.NoArgsConstructor;

import java.io.IOException;

@NoArgsConstructor
public class SexoSerializer extends JsonSerializer<Sexo> {

    public void serialize(Sexo sexo, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(sexo.getTipo());
    }
}
