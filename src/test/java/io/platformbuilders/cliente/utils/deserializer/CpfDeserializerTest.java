package io.platformbuilders.cliente.utils.deserializer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CpfDeserializerTest {


    @Test
    void testeDeserializacao() {
        final var cpf = "317.050.120-86";
        Assert.assertEquals("31705012086", CpfDeserializer.removerCaractersEspeciais(cpf));
    }
}
