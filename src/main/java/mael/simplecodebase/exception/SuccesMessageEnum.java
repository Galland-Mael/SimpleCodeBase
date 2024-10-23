package mael.simplecodebase.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SuccesMessageEnum implements Message {
    CREATED("Created"),
    UPDATED("Updated"),
    DELETED("Deleted"),

    // Auhtor
    AUTHOR_CREATED("Author created successfully"),
    AUTHOR_UPDATED("Author updated successfully"),
    AUTHOR_DELETED("Author deleted successfully"),
    CLIENT_CREATED("Client created successfully"),
    LIBRARY_CREATED("LIBRARY created successfully"),
    BOOK_CREATED("Book created successfully");

    private String message;
}
