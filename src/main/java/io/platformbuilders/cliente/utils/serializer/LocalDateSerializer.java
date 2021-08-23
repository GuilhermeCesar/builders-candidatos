package io.platformbuilders.cliente.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class LocalDateSerializer extends JsonSerializer<LocalDate> {
    private static final String PATTERN = "dd/MM/yyyy";

    public void serialize(LocalDate zonedDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        jsonGenerator.writeString(formatter.format(zonedDateTime));
    }
}
