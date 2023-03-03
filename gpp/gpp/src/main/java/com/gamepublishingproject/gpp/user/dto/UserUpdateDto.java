package com.gamepublishingproject.gpp.user.dto;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;


@Getter
public class UserUpdateDto {

    private Long userId;

    @NotBlank
    private String nickName;


    @NotBlank
    private Long wallet;


    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
