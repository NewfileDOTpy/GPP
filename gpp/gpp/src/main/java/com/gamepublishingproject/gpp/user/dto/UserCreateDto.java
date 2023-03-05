package com.gamepublishingproject.gpp.user.dto;


import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
public class UserCreateDto {

    @NotBlank
    private String email;


    @NotBlank
    private String userName;

    @NotBlank
    private String nickName;



}
