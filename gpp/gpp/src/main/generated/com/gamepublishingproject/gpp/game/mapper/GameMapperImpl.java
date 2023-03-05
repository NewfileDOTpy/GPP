package com.gamepublishingproject.gpp.game.mapper;

import com.gamepublishingproject.gpp.game.dto.GameCreateDto;
import com.gamepublishingproject.gpp.game.dto.GameResponseDto;
import com.gamepublishingproject.gpp.game.dto.GameUpdateDto;
import com.gamepublishingproject.gpp.game.entity.Game;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-05T16:27:07+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class GameMapperImpl implements GameMapper {

    @Override
    public Game gameCreateDtoToGame(GameCreateDto gameCreateDto) {
        if ( gameCreateDto == null ) {
            return null;
        }

        Game game = new Game();

        game.setGameName( gameCreateDto.getGameName() );
        game.setDescription( gameCreateDto.getDescription() );
        game.setPrice( gameCreateDto.getPrice() );

        return game;
    }

    @Override
    public Game gameUpdateDtoToGame(GameUpdateDto gameUpdateDto) {
        if ( gameUpdateDto == null ) {
            return null;
        }

        Game game = new Game();

        game.setGameId( gameUpdateDto.getGameId() );
        game.setGameName( gameUpdateDto.getGameName() );
        game.setDescription( gameUpdateDto.getDescription() );
        game.setPrice( gameUpdateDto.getPrice() );

        return game;
    }

    @Override
    public GameResponseDto gameToGameResponseDto(Game game) {
        if ( game == null ) {
            return null;
        }

        GameResponseDto gameResponseDto = new GameResponseDto();

        gameResponseDto.setGameId( game.getGameId() );
        gameResponseDto.setGameName( game.getGameName() );
        gameResponseDto.setDescription( game.getDescription() );
        if ( game.getPrice() != null ) {
            gameResponseDto.setPrice( game.getPrice() );
        }

        return gameResponseDto;
    }

    @Override
    public List<GameResponseDto> gameToGameResponseDtos(List<Game> games) {
        if ( games == null ) {
            return null;
        }

        List<GameResponseDto> list = new ArrayList<GameResponseDto>( games.size() );
        for ( Game game : games ) {
            list.add( gameToGameResponseDto( game ) );
        }

        return list;
    }
}
