package io.platformbuilders.cliente.utils.deserializer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static io.platformbuilders.cliente.enumeration.Sexo.FEMININO;
import static io.platformbuilders.cliente.enumeration.Sexo.MASCULINO;
import static io.platformbuilders.cliente.enumeration.Sexo.OUTROS;
import static io.platformbuilders.cliente.utils.deserializer.SexoDeserializer.deserialize;

class SexoDeserializerTest {

    @Test
    void testeDeserializacao() {
        Assert.assertSame(MASCULINO, deserialize("M"));
        Assert.assertSame(FEMININO, deserialize("F"));
        Assert.assertSame(OUTROS, deserialize("OUTROS"));
    }
}
