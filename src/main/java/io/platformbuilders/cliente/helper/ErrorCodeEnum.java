package io.platformbuilders.cliente.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    ERROR_VALID_DATA("error.valid.data");

    private final String messageKey;
}
