package com.gamepublishingproject.gpp.category.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CategoryCreateDto {
    @NotBlank
    private String genre;
}
