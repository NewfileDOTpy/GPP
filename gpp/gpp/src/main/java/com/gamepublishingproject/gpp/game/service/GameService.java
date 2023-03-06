package com.gamepublishingproject.gpp.game.service;

import com.gamepublishingproject.gpp.game.entity.Game;
import com.gamepublishingproject.gpp.game.repository.GameRepository;
import com.gamepublishingproject.gpp.user.dto.BasketAddGameDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Game updateGame(Game game) {

        Game findGame = gameRepository.findById(game.getGameId()).orElse(null);


        Optional.ofNullable(game.getGameName())
                .ifPresent(gameName -> findGame.setGameName(gameName));
        Optional.ofNullable(game.getDescription())
                .ifPresent(description -> findGame.setDescription(description));
        Optional.ofNullable(game.getPrice())
                .ifPresent(price -> findGame.setPrice(price));

        return gameRepository.save(findGame);
    }

    public Game findGame(long gameId) {
        return gameRepository.findById(gameId).orElseThrow(NullPointerException::new);
    }

    public Game findGameName(String gameName) {
        return gameRepository.findByGameName(gameName);
    }
    public Page<Game> findGames(int page, int size) {
            return gameRepository.findAll(PageRequest.of(page, size,
                    Sort.by("gameId").descending()));
    }

    public List<Game> gameList(BasketAddGameDto basketAddGameDto) {
        List<Game> games = basketAddGameDto.getGameIdList().stream()
                .map(game -> findGame(game.getGameId()))
                .collect(Collectors.toList());
        return games;
    }

    public void deleteGame(long gameId) {
        gameRepository.deleteById(gameId);
    }
}
