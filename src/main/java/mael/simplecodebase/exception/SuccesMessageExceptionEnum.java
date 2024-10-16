package mael.simplecodebase.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccesMessageExceptionEnum implements MessageException {
    CREATED("Created"),
    UPDATED("Updated"),
    DELETED("Deleted");

    private String message;
}
