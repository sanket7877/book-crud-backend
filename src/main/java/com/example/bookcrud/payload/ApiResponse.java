package com.example.bookcrud.payload;

import lombok.Data;

@Data
public class ApiResponse {
    private Object data;
    private boolean Status;
    private String message;

    public ApiResponse(Object data, boolean status, String message) {
        this.data = data;
        Status = status;
        this.message = message;
    }
}