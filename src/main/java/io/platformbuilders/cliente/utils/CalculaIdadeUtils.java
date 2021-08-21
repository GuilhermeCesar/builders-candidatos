package io.platformbuilders.cliente.utils;

import java.time.LocalDate;
import java.time.Period;

public class CalculaIdadeUtils {

    private CalculaIdadeUtils() {
    }

    public static Integer calculaIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
