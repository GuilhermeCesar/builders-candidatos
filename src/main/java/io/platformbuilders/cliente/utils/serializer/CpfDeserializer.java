package io.platformbuilders.cliente.utils.serializer;

public class CpfDeserializer {

    private CpfDeserializer() {
        super();
    }

    public static String removerCaractersEspeciais(String cpf) {
        return cpf.replaceAll("[\\.\\-]", "");
    }
}
