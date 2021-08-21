package io.platformbuilders.cliente.dto;

import lombok.Builder;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;

@With
@Jacksonized
@Builder
public record ErrorMessageDTO(LocalDateTime timestamp,
                              String error,
                              String message,
                              String path,
                              List<String> errorsList) {

    public ErrorMessageDTO {
        timestamp = now();
    }
}
