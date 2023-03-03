package com.gamepublishingproject.gpp.game.repository;

import com.gamepublishingproject.gpp.game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByGameName(String gameName);
}
