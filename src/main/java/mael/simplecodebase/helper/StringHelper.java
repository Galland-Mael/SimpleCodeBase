package mael.simplecodebase.helper;

import mael.simplecodebase.exception.Message;

public final class StringHelper {

    // Prevent instantiation
    private StringHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static String format(Message messageEnum, Object... args) {
        return String.format(messageEnum.getMessage() , args);
    }
}