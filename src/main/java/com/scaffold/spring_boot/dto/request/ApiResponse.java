package com.scaffold.spring_boot.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
// null attribute will not being shown
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    // default code is sucess
    private int code = 200;
    private String message;
    private T result;
}