package com.gamepublishingproject.gpp.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class CategoryDto {

    @Getter
    public static class Create {
        @NotBlank
        private String genre;
    }

    @Getter
    @AllArgsConstructor
    public static class Update {
        private Long categoryId;

        @NotBlank
        private String genre;

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Response {
        private Long categoryId;
        private String genre;
    }
}
