package com.gamepublishingproject.gpp.user.entity;


import com.gamepublishingproject.gpp.basket.Basket;
import com.gamepublishingproject.gpp.library.Library;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usersId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Column
    @ColumnDefault("0")
    private Long wallet;

    @Column
    private LocalDateTime localDateTime = LocalDateTime.now();

    @Column
    private LocalDateTime modifiedTime = LocalDateTime.now();

    @OneToOne(mappedBy = "users", cascade = CascadeType.PERSIST)
    private Basket basket;


    @OneToOne(mappedBy = "users", cascade = CascadeType.PERSIST)
    private Library library;


    public void setBasket(Basket basket){
        this.basket = basket;
        if(basket.getUsers()!= this){
            basket.setUser(this);
        }
    }

    public void setLibrary(Library library){
        this.library = library;
        if(library.getUsers()!= this){
            library.setUser(this);
        }
    }

}
