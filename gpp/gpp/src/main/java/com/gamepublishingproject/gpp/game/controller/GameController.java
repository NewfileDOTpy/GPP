package com.gamepublishingproject.gpp.game.controller;

import com.gamepublishingproject.gpp.game.dto.GameCreateDto;
import com.gamepublishingproject.gpp.game.dto.GameUpdateDto;
import com.gamepublishingproject.gpp.response.MultiResponseDto;
import com.gamepublishingproject.gpp.game.entity.Game;
import com.gamepublishingproject.gpp.game.mapper.GameMapper;
import com.gamepublishingproject.gpp.game.service.GameService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;
    private final GameMapper mapper;

    public GameController(GameService gameService, GameMapper gameMapper) {
        this.gameService = gameService;
        this.mapper = gameMapper;
    }

    @PostMapping
    public ResponseEntity createGame(@RequestBody GameCreateDto gameCreateDto) {
        Game game = mapper.gameCreateDtoToGame(gameCreateDto);
        gameService.createGame(game);

        return new ResponseEntity<>(
                mapper.gameToGameResponseDto(game),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{game-id}")
    public ResponseEntity updateGame(@PathVariable("game-id") @Positive Long gameId,
                                     @RequestBody GameUpdateDto gameUpdateDto) {
        gameUpdateDto.setGameId(gameId);
        Game game = gameService.updateGame(mapper.gameUpdateDtoToGame(gameUpdateDto));

        return new ResponseEntity<>(
                mapper.gameToGameResponseDto(game),
                HttpStatus.OK);
    }

    @GetMapping("/{game-id}")
    public ResponseEntity getGame(@PathVariable("game-id") @Positive long gameId) {
        Game game = gameService.findGame(gameId);

        return new ResponseEntity<>(
                mapper.gameToGameResponseDto(game),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getGames(@Positive @RequestParam int page, @Positive @RequestParam int size) {
        Page<Game> pageGames = gameService.findGames(page - 1, size);
        List<Game> games = pageGames.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.gameToGameResponseDtos(games),
                        pageGames),
                HttpStatus.OK);
    }

    @GetMapping("/gameName/{game-name}")
    public ResponseEntity getGameName(@PathVariable("game-name") String gameName) {
        Game game = gameService.findGameName(gameName);

        return new ResponseEntity<>(
                mapper.gameToGameResponseDto(game),
                HttpStatus.OK);
    }

    @DeleteMapping("/{game-id}")
    public ResponseEntity deleteGame(@PathVariable("game-id") @Positive Long gameId) {
        gameService.deleteGame(gameId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}