package com.gamepublishingproject.gpp.related;

import com.gamepublishingproject.gpp.game.entity.Game;
import com.gamepublishingproject.gpp.library.entity.Library;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class LibraryGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libraryGameId;

    @Column
    @ColumnDefault("false")
    private Boolean installed;


    @ManyToOne
    @JoinColumn(name = "LIBRARY_ID")
    private Library library;

    @ManyToOne
    @JoinColumn(name = "GAME_ID")
    private Game game;


    public void addLibrary(Library library){
        this.library = library;
        if(!this.library.getLibraryGame().contains(this)){
            this.library.getLibraryGame().add(this);
        }
    }

    public void addGame(Game game){
        this.game = game;
        if(!this.game.getLibraryGameList().contains(this)){
            this.game.getLibraryGameList().add(this);
        }
    }


}
