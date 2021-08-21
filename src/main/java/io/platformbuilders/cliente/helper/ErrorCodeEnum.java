package io.platformbuilders.cliente.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    ERROR("error");

    private final String messageKey;
}
