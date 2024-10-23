package mael.simplecodebase.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessageEnum implements Message {
    NOT_FOUND("Not Found"),
    INTERNAL_SERVER_ERROR("Internal Server Error"),
    BAD_REQUEST("Bad Request"),
    UNAUTHORIZED("Unauthorized"),

    S_LITERAL_TYPE_NOT_FOUND("SLiteraryType Not Found code :  %s"),
    AUTHOR_NOT_FOUND("Auhtor Not Found id :  %s"),
    BOOK_NOT_FOUND("Book Not Found id :  %s"),
    CLIENT_NOT_FOUND("Client Not Found id :  %s"),
    LIBRARY_NOT_FOUND("Library Not Found id :  %s");

    private String message;
}
