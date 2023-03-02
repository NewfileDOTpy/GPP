package com.gamepublishingproject.gpp.user.entity;


import com.gamepublishingproject.gpp.basket.Basket;
import com.gamepublishingproject.gpp.library.Library;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor
@Entity(name = "USERS")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @Column(nullable = false,updatable = false, unique = true)
    private String email;

    @Column(nullable = false, updatable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String nickName;

    @Column
    @ColumnDefault("0")
    private Long wallet;

    @OneToOne(mappedBy = "Users", cascade = CascadeType.PERSIST)
    private Basket basket;


    @OneToOne(mappedBy = "Users", cascade = CascadeType.PERSIST)
    private Library library;

}
