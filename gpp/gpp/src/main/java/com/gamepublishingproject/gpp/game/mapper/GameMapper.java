package com.gamepublishingproject.gpp.game.mapper;

import com.gamepublishingproject.gpp.game.dto.GameCreateDto;
import com.gamepublishingproject.gpp.game.dto.GameResponseDto;
import com.gamepublishingproject.gpp.game.dto.GameUpdateDto;
import com.gamepublishingproject.gpp.game.entity.Game;
import com.gamepublishingproject.gpp.user.dto.BasketAddGameDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper {
    Game gameCreateDtoToGame(GameCreateDto gameCreateDto);
    Game gameUpdateDtoToGame(GameUpdateDto gameUpdateDto);
    GameResponseDto gameToGameResponseDto(Game game);
    List<GameResponseDto> gameToGameResponseDtos(List<Game> games);

}
