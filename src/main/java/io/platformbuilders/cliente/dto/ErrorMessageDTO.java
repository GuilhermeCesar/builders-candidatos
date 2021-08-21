package io.platformbuilders.cliente.dto;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;

@Value
@With
@Jacksonized
@Builder
public class ErrorMessageDTO {

    @Builder.Default
    LocalDateTime timestamp = now();
    String error;
    String message;
    String path;
    List<String> errorsList;
    String trace;

}
