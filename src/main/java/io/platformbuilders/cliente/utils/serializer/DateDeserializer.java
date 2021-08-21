package io.platformbuilders.cliente.utils.serializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateDeserializer {

    private DateDeserializer() {
        super();
    }

    /**
     * Deserializa objeto no formato
     *
     * @param date
     * @return
     */
    public static LocalDate localDatePT_BR(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(date, formatter);
    }
}
