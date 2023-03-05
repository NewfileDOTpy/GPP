package com.gamepublishingproject.gpp.user.dto;

import com.gamepublishingproject.gpp.basket.Basket;
import com.gamepublishingproject.gpp.library.Library;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Builder
@Getter
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
