package com.gamepublishingproject.gpp.game.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameCreateDto {
    private String gameName;

    private String description;

    private int price;
}
