package com.project.ErrorNote.global.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum BaseResponseStatus {

    /**
     * 200 : 요청 성공
     */
    SUCCESS(true, HttpStatus.OK.value(), "요청에 성공하였습니다."),


    /**
     * 400 : Request, Response 오류
     */
    BAD_REQUEST(false, HttpStatus.BAD_REQUEST.value(), "잘못된 요청입니다."),
    USER_NOT_FOUND(false, HttpStatus.BAD_REQUEST.value(), "잘못된 요청입니다."),
    INVALID_PASSWORD(false, HttpStatus.BAD_REQUEST.value(), "잘못된 요청입니다."),

    /**
     * 500 :  Database, Server 오류
     */
    DATABASE_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, HttpStatus.INTERNAL_SERVER_ERROR.value(), "서버와의 연결에 실패하였습니다.");

    private final boolean isSuccess;
    private final int status;
    private final String message;

    BaseResponseStatus(boolean isSuccess, int status, String message) {
        this.isSuccess = isSuccess;
        this.status = status;
        this.message = message;
    }
}
