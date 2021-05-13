package com.bookstore.BookStoreMicroservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Response {

    private String message;
    private Object data;

    public Response( String message) {
        this.message = message;
    }

    public Response( String message, Object data) {
        this.message = message;
        this.data = data;
    }

}