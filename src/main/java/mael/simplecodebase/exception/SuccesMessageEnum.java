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

    // Client
    CLIENT_CREATED("Client created successfully"),
    CLIENT_UPDATED("Client updated successfully"),
    CLIENT_DELETED("Client deleted successfully"),

    // Library
    LIBRARY_CREATED("LIBRARY created successfully"),
    LIBRARY_UPDATED("LIBRARY updated successfully"),
    LIBRARY_DELETED("LIBRARY deleted successfully"),

    // Book
    BOOK_CREATED("Book created successfully"),
    BOOK_UPDATED("Book updated successfully"),
    BOOK_DELETED("Book deleted successfully");

    private String message;
}
