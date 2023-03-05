package com.gamepublishingproject.gpp.user.dto;

import com.gamepublishingproject.gpp.game.entity.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BasketAddGameDto {

    private List<AddGameDto> gameIdList;

}
