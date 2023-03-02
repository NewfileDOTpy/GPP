package com.gamepublishingproject.gpp.basket;


import com.gamepublishingproject.gpp.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long basketId;


    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;


    public void setUser(User user){
        this.user = user;
        if(user.getBasket() != this){
            user.setBasket(this);
        }
    }

}
