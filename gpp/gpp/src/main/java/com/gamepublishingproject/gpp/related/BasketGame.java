package com.gamepublishingproject.gpp.related;

import com.gamepublishingproject.gpp.basket.Basket;
import com.gamepublishingproject.gpp.game.entity.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BasketGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BasketGame;

    @ManyToOne
    @JoinColumn(name = "BASKET_ID")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "GAME_ID")
    private Game game;

}
