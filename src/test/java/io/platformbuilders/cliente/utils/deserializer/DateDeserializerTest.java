package io.platformbuilders.cliente.utils.deserializer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DateDeserializerTest {


    @Test
    void testeDeserializacao() {
        final var aniversario = LocalDate.of(1993, 6, 9);
        var data = LocalDateDeserializer.localDatePtBr("09/06/1993");

        Assert.assertEquals(aniversario.getDayOfMonth(), data.getDayOfMonth());
        Assert.assertEquals(aniversario.getMonthValue(), data.getMonthValue());
        Assert.assertEquals(aniversario.getYear(), data.getYear());
        Assert.assertEquals(aniversario, data);
    }
}
