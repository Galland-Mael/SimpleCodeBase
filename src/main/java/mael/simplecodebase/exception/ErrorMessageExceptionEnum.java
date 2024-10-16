package mael.simplecodebase.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageExceptionEnum implements MessageException {
    NOT_FOUND("Not Found"),
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    BAD_REQUEST("Bad Request"),
    UNAUTHORIZED("Unauthorized"),

    S_LITERAL_TYPE_NOT_FOUND("SLiteraryType Not Found pour le code :  %s");

    private String message;
}
