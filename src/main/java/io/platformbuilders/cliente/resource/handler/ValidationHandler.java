package io.platformbuilders.cliente.resource.handler;

import io.platformbuilders.cliente.helper.MessageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ValidationHandler {

    private final MessageHelper messageHelper;
}
