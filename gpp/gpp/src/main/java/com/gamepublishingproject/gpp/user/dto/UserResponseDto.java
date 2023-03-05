package com.gamepublishingproject.gpp.user.dto;

import com.gamepublishingproject.gpp.basket.Basket;
import com.gamepublishingproject.gpp.library.entity.Library;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class UserResponseDto {


    private Long userid;


    private String email;


    private String userName;


    private String nickName;

    private Long wallet;

    private Library library;

    private Basket basket;
}
