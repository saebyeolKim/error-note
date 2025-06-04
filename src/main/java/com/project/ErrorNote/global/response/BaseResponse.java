package com.project.ErrorNote.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import static com.project.ErrorNote.global.response.BaseResponseStatus.*;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"status", "message", "data"})
public class BaseResponse<T> {

    private final Boolean isSuccess;
    private final int status;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    // 요청 성공
    public BaseResponse(T data) {
        this.isSuccess = SUCCESS.isSuccess();
        this.status = SUCCESS.getStatus();
        this.message = SUCCESS.getMessage();
        this.data = data;
    }

    // 요청 실패
    public BaseResponse(BaseResponseStatus status) {
        this.isSuccess = status.isSuccess();
        this.status = status.getStatus();
        this.message = status.getMessage();
    }
}
