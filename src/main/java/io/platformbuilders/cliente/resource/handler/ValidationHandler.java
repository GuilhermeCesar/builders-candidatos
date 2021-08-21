package io.platformbuilders.cliente.resource.handler;

import io.platformbuilders.cliente.dto.ErrorMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ValidationHandler {

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ErrorMessageDTO exceptionHandler(ValidationException e) {
        log.debug(e.getMessage(), e.getCause());
        return ErrorMessageDTO
                .builder()
                .message(e.getMessage())
                .error(e.getMessage())
                .build();
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorMessageDTO constraintViolationExceptionHandler(ConstraintViolationException e) {
        log.debug(e.getMessage(), e.getCause());
        var errors = e.getConstraintViolations()
                .parallelStream()
                .map(ConstraintViolation::getMessage)
                .toList();

        return ErrorMessageDTO
                .builder()
                .message(e.getMessage())
                .error(e.getClass().getName())
                .errorsList(errors)
                .build();
    }

    @ResponseBody
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorMessageDTO handleValidationExceptions(MethodArgumentNotValidException ex) {
        var listErrors = ex.getBindingResult().getAllErrors().parallelStream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

        listErrors.add(ex.getMessage());

        return ErrorMessageDTO
                .builder()
                .message(listErrors.get(0))
                .error(ex.getClass().getName())
                .errorsList(listErrors)
                .build();
    }
}
