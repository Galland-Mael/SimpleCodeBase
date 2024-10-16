package mael.simplecodebase.response;

import lombok.AllArgsConstructor;
import mael.simplecodebase.exception.MessageException;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class BaseResponse<T> {
    private MessageException message;
    private HttpStatus httpStatus;
    private T data;
}
