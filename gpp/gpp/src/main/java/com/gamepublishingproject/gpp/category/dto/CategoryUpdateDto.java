package com.gamepublishingproject.gpp.category.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CategoryUpdateDto {
    private Long categoryId;
    @NotBlank
    private String genre;

    public void setCategoryId(Long categoryId){this.categoryId = categoryId;}

}
