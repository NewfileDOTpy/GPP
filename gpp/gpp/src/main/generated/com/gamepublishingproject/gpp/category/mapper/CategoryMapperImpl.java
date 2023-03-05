package com.gamepublishingproject.gpp.category.mapper;

import com.gamepublishingproject.gpp.category.dto.CategoryDto.Create;
import com.gamepublishingproject.gpp.category.dto.CategoryDto.Response;
import com.gamepublishingproject.gpp.category.dto.CategoryDto.Update;
import com.gamepublishingproject.gpp.category.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-05T22:50:17+0900",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.16 (Azul Systems, Inc.)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category categoryCreateDtoToCategory(Create requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Category category = new Category();

        category.setGenre( requestBody.getGenre() );

        return category;
    }

    @Override
    public Category categoryUpdateDtoToCategory(Update requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryId( requestBody.getCategoryId() );
        category.setGenre( requestBody.getGenre() );

        return category;
    }

    @Override
    public Response categoryToCategoryResponseDto(Category category) {
        if ( category == null ) {
            return null;
        }

        Long categoryId = null;
        String genre = null;

        categoryId = category.getCategoryId();
        genre = category.getGenre();

        Response response = new Response( categoryId, genre );

        return response;
    }

    @Override
    public List<Response> categoriesToCategoryResponseDtos(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<Response> list = new ArrayList<Response>( categories.size() );
        for ( Category category : categories ) {
            list.add( categoryToCategoryResponseDto( category ) );
        }

        return list;
    }
}
