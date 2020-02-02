package com.demo.products.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true)
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ErrorDetails {

    private int code;
    private String key;
    private String message;

    public ErrorDetails(int code, String message) {
        this(code, null, message);
    }
}
