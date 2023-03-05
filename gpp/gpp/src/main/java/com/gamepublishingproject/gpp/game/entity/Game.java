package com.gamepublishingproject.gpp.game.entity;

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

    @Column
    private String gameName;

    @Column
    private String description;

    @Column
    private Integer price;

    @Column
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime modifiedAt = LocalDateTime.now();


    @OneToMany(mappedBy = "game")
    private List<LibraryGame> libraryGame = new ArrayList<>();


    public void addLibraryGame(LibraryGame libraryGame){
        this.libraryGame.add(libraryGame);
        if(libraryGame.getGame() != this){
            libraryGame.addGame(this);
        }

    }


}