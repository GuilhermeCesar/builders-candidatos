package io.platformbuilders.cliente.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    ERROR_NOT_FOUND("error.not.found"),

    SWAGGER_VERSION("swagger.version"),
    SWAGGER_DESCRIPTION("swagger.description"),
    SWAGGER_NAME("swagger.name");

    private final String messageKey;
}
