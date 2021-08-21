package io.platformbuilders.cliente.utils.serializer;

import org.junit.Assert;
import org.junit.Test;

import static io.platformbuilders.cliente.enumeration.Sexo.FEMININO;
import static io.platformbuilders.cliente.enumeration.Sexo.MASCULINO;
import static io.platformbuilders.cliente.enumeration.Sexo.OUTROS;
import static io.platformbuilders.cliente.utils.serializer.SexoDeserializer.deserialize;

public class SexoDeserializerTest {

    @Test
    public void testeSerializacao() {
        Assert.assertSame(MASCULINO, deserialize("M"));
        Assert.assertSame(FEMININO, deserialize("F"));
        Assert.assertSame(OUTROS, deserialize("OUTROS"));
    }
}
