package com.gamepublishingproject.gpp.category.exception;

import lombok.Getter;

public enum ExceptionCode {
    CATEGORY_NOT_FOUND(404, "Category not found"),
    CATEGORY_EXISTS(409, "Category exists");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message){
        this.status = code;
        this.message = message;
    }
}
