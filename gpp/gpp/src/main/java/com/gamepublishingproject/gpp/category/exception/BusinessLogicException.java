package com.gamepublishingproject.gpp.category.exception;

import com.gamepublishingproject.gpp.category.controller.ExceptionCode;
import lombok.Getter;

public class BusinessLogicException extends RuntimeException {
    @Getter
    private ExceptionCode exceptionCode;

    public BusinessLogicException(ExceptionCode exceptionCode){
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
