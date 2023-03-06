package com.gamepublishingproject.gpp.library.entity;



import com.gamepublishingproject.gpp.related.LibraryGame;
import com.gamepublishingproject.gpp.user.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Library {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libraryId;


    @OneToOne
    @JoinColumn(name = "USERS_ID")
    private Users users;

    @OneToMany(mappedBy = "library", cascade = CascadeType.PERSIST)
    private List<LibraryGame> libraryGame = new ArrayList<>();



    public void setUser(Users user){
        this.users = user;
        if(user.getLibrary() != this){
            user.setLibrary(this);
        }
    }

    public void addLibraryGame(LibraryGame libraryGame){
        this.libraryGame.add(libraryGame);
        if (libraryGame.getLibrary() != this){
            libraryGame.addLibrary(this);
        }

    }

}
