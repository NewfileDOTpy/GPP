package com.gamepublishingproject.gpp.user.dto;

import com.gamepublishingproject.gpp.basket.Basket;
import com.gamepublishingproject.gpp.library.entity.Library;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserResponseDto {


    private Long userid;


    private String email;


    private String userName;


    private String nickName;

    private Long wallet;

//    private Library library;
//
//    private Basket basket;
}
