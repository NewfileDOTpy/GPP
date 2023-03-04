package com.gamepublishingproject.gpp.category.mapper;

import com.gamepublishingproject.gpp.category.dto.CategoryDto;
import com.gamepublishingproject.gpp.category.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category categoryCreateDtoToCategory(CategoryDto.Create requestBody);
    Category categoryUpdateDtoToCategory(CategoryDto.Update requestBody);

    CategoryDto.Response categoryToCategoryResponseDto(Category category);

    List<CategoryDto.Response> categoriesToCategoryResponseDtos(List<Category> categories);
}
