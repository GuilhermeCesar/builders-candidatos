package io.platformbuilders.cliente.utils.serializer;

import org.junit.Assert;
import org.junit.Test;

public class CpfDeserializerTest {


    @Test
    public void testeDeserializacao() {
        final var cpf = "317.050.120-86";
        Assert.assertEquals("31705012086", CpfDeserializer.removerCaractersEspeciais(cpf));
    }
}
