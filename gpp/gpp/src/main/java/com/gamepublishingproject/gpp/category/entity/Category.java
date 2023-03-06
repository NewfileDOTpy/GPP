package com.gamepublishingproject.gpp.category.entity;

import com.gamepublishingproject.gpp.related.GameCategory;
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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false)
    private String genre;
    @OneToMany(mappedBy = "category")
    private List<GameCategory> gameCategoryList = new ArrayList<>();

    public Category(String genre) {
        this.genre = genre;
    }

}
