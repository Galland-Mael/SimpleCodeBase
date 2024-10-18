package mael.simplecodebase.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccesMessageEnum implements Message {
    CREATED("Created"),
    UPDATED("Updated"),
    DELETED("Deleted"),

    AUTHOR_CREATED("Author created successfully"),
    BOOK_CREATED("Book created successfully");

    private String message;
}
