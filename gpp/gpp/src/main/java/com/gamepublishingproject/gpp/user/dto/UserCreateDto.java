package com.gamepublishingproject.gpp.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserCreateDto {

    @NotBlank
    @Email
    private String email;


    @NotBlank
    private String userName;

    @NotBlank
    private String nickName;

}
