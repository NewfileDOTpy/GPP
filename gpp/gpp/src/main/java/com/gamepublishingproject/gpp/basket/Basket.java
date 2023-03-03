package com.gamepublishingproject.gpp.basket;



import com.gamepublishingproject.gpp.user.entity.Users;
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
    @JoinColumn(name = "USERS_ID")
    private Users users;


    public void setUser(Users user){
        this.users = user;
        if(user.getBasket() != this){
            user.setBasket(this);
        }
    }

}
