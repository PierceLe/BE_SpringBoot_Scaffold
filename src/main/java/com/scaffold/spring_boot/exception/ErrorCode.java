package com.scaffold.spring_boot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_EXISTED(400, "User already existed"),

    ;
    private int code;
    private String message;

}
