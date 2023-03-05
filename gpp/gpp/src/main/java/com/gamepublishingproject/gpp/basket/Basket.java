package com.gamepublishingproject.gpp.basket;



import com.gamepublishingproject.gpp.game.entity.Game;
import com.gamepublishingproject.gpp.related.BasketGame;
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
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;

    @OneToOne
    @JoinColumn(name = "USERS_ID")
    private Users users;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL)
    private List<BasketGame> basketGameList = new ArrayList<>();


    public void setUser(Users user){
        this.users = user;
        if(user.getBasket() != this){
            user.setBasket(this);
        }
    }

}
