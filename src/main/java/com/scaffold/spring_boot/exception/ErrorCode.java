package com.scaffold.spring_boot.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_EXISTED(400, "User already existed"),
    UNAUTHORIZED(401, "Unauthorized"),
    UNCATEGORIZED_EXCEPTION(406, "Uncategorized exception"),
    USER_NAME_NOT_VALID(400, "Username is not valid"),
    USER_PASSWORD_NOT_VALID(400, "UserPassword is not valid"),
    ;
    private int code;
    private String message;

}
