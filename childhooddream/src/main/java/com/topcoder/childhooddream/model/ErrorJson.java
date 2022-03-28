package com.topcoder.childhooddream.model;

import lombok.Getter;

@Getter
public class ErrorJson {
    private String message;

    public ErrorJson(String message) {
        this.message = message;
    }
}
