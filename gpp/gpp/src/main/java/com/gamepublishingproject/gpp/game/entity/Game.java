package com.gamepublishingproject.gpp.game.entity;


import com.gamepublishingproject.gpp.related.BasketGame;
import com.gamepublishingproject.gpp.related.GameCategory;
import com.gamepublishingproject.gpp.related.LibraryGame;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    private String gameName;

    private String description;

    private Integer price;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime modifiedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "game")
    private List<BasketGame> basketGameList = new ArrayList<>();

    @OneToMany(mappedBy = "game")
    private List<LibraryGame> libraryGameList = new ArrayList<>();

    @OneToMany(mappedBy = "game")
    private List<GameCategory> gameCategoryList = new ArrayList<>();

}