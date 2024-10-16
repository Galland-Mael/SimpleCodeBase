package mael.simplecodebase.helper;

import mael.simplecodebase.exception.MessageException;

public final class StringHelper {

    // Prevent instantiation
    private StringHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static String format(MessageException messageExceptionEnum, Object... args) {
        return String.format(messageExceptionEnum.getMessage() , args);
    }
}