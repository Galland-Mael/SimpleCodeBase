package mael.simplecodebase.response;

import mael.simplecodebase.exception.MessageException;

public class BaseResponse<T> {
    private MessageException message;
    private T data;

    public BaseResponse(MessageException message, T data) {
        this.message = message;
        this.data = data;
    }

}
