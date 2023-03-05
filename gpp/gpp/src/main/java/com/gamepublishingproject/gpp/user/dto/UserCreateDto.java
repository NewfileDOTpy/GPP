package com.gamepublishingproject.gpp.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreateDto {

    @NotBlank
    private String email;


    @NotBlank
    private String userName;

    @NotBlank
    private String nickName;



}
