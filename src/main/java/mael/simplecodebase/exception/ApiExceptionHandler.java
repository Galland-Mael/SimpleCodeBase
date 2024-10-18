package mael.simplecodebase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<Object> handleApiException(ApiException e) {

        ApiFinalException apiFinalException = new ApiFinalException(
                e.getMessage(),
                e.getHttpStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiFinalException,  e.getHttpStatus());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleApiException(MethodArgumentNotValidException e) {

        ApiFinalException apiFinalException = new ApiFinalException(
                formatBindingResult(e.getBindingResult()),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiFinalException,  HttpStatus.BAD_REQUEST);
    }

    private static String formatBindingResult(BindingResult bindingResult) {
        return Stream.concat(
                bindingResult.getFieldErrors().stream().map(error -> "%s: %s".formatted(error.getField(), error.getDefaultMessage())),
                bindingResult.getGlobalErrors().stream().map(ObjectError::getDefaultMessage)
        ).collect(Collectors.joining(","));
    }
}
