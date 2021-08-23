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

    public static String serialize(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        return formatter.format(localDate);
    }

    public void serialize(LocalDate localDate, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator
                .writeString(LocalDateSerializer.serialize(localDate));
    }
}
