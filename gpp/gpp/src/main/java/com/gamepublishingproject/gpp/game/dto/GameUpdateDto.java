package com.gamepublishingproject.gpp.game.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GameUpdateDto {
    private Long gameId;

    private String gameName;

    private String description;

    private Integer price;

}
