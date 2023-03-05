package com.gamepublishingproject.gpp.library;



import com.gamepublishingproject.gpp.user.entity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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





    public void setUser(Users user){
        this.users = user;
        if(user.getLibrary() != this){
            user.setLibrary(this);
        }
    }

}
