package com.gamepublishingproject.gpp.category.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CategoryResponseDto {
    private Long categoryId;
    private String genre;
}
