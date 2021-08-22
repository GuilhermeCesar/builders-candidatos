package io.platformbuilders.cliente.utils.deserializer;

public class CpfDeserializer {

    private CpfDeserializer() {
        super();
    }

    public static String removerCaractersEspeciais(String cpf) {
        return cpf.replaceAll("[\\.\\-]", "");
    }
}
