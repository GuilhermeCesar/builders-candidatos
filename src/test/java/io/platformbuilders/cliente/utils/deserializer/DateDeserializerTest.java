package io.platformbuilders.cliente.utils.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DateDeserializerTest {

    @Test
    void testeDeserializacao() {
        final var aniversario = LocalDate.of(1993, 6, 9);
        var data = LocalDateDeserializer.localDatePtBr("09/06/1993");

        assertEquals(aniversario.getDayOfMonth(), data.getDayOfMonth());
        assertEquals(aniversario.getMonthValue(), data.getMonthValue());
        assertEquals(aniversario.getYear(), data.getYear());
        assertEquals(aniversario, data);
    }

    @SneakyThrows
    @Test
    void testeDeserializacaoObjeto() {
        var mapper = new ObjectMapper();
        var deserializer = new LocalDateDeserializer();

        InputStream stream = new ByteArrayInputStream("""
                {
                "dataNascimento": "09/06/1993"
                }
                """.getBytes());
        JsonParser parser = mapper.getFactory().createParser(stream);
        final var deserializationContext = mapper.getDeserializationContext();
        parser.nextToken();
        parser.nextToken();
        parser.nextToken();

        var localDate = deserializer.deserialize(parser, deserializationContext);

        assertNotNull(localDate);
        assertEquals(LocalDate.of(1993, 6, 9), localDate);
    }
}
