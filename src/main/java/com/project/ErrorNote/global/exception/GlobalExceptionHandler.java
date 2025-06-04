package com.project.ErrorNote.global.exception;

import com.project.ErrorNote.global.response.BaseException;
import com.project.ErrorNote.global.response.BaseResponse;
import static com.project.ErrorNote.global.response.BaseResponseStatus.*;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 예: 이메일 없음
    @ExceptionHandler(UsernameNotFoundException.class)
    public BaseResponse<?> handleUsernameNotFound(UsernameNotFoundException ex) {
        return new BaseResponse<>(USER_NOT_FOUND);
    }

    // 예: 비밀번호 틀림
    @ExceptionHandler(BadCredentialsException.class)
    public BaseResponse<?> handleBadCredentials(BadCredentialsException ex) {
        return new BaseResponse<>(INVALID_PASSWORD);
    }

    @ExceptionHandler(BaseException.class)
    public BaseResponse<?> handleBaseException(BaseException ex) {
        return new BaseResponse<>(ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse<?> handleBaseException(Exception ex) {
        ex.printStackTrace();
        return new BaseResponse<>(SERVER_ERROR);
    }
}
