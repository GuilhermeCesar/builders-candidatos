package io.platformbuilders.cliente.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    ERROR_NOT_FOUND("error.not.found");

    private final String messageKey;
}
