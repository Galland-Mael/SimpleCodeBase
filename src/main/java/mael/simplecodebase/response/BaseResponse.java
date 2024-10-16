package mael.simplecodebase.response;

import lombok.Getter;
import lombok.Setter;
import mael.simplecodebase.exception.SuccesMessageEnum;

@Getter
@Setter
public class BaseResponse<T> {
    private String message;
    private T data;

    public BaseResponse(SuccesMessageEnum message, T data) {
        this.message = message.getMessage();
        this.data = data;
    }

}
