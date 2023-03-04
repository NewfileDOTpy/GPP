package com.gamepublishingproject.gpp.category.repository;

import com.gamepublishingproject.gpp.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByGenre(String genre);
}
