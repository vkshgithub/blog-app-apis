package com.mycode.blog.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class ApiResponse {

    private String message;
    private Boolean status;


}
