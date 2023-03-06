package com.gamepublishingproject.gpp.related;

import com.gamepublishingproject.gpp.category.entity.Category;
import com.gamepublishingproject.gpp.game.entity.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class GameCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameCategoryId;

    @ManyToOne
    @JoinColumn(name = "GAME_ID")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
}
