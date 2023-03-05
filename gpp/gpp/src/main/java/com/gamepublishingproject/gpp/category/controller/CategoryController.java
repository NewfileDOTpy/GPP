package com.gamepublishingproject.gpp.category.controller;

import com.gamepublishingproject.gpp.category.dto.CategoryDto;
import com.gamepublishingproject.gpp.category.entity.Category;
import com.gamepublishingproject.gpp.category.mapper.CategoryMapper;
import com.gamepublishingproject.gpp.category.repository.CategoryRepository;
import com.gamepublishingproject.gpp.category.response.SingleResponseDto;
import com.gamepublishingproject.gpp.category.service.CategoryService;
import com.gamepublishingproject.gpp.category.utils.UriCreator;
import com.gamepublishingproject.gpp.response.MultiResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/category")
@Validated
@Slf4j
public class CategoryController {
    private final static String CATEGORY_DEFAULT_URL = "/category";
    private CategoryRepository categoryRepository;
    private CategoryService categoryService;

    private final CategoryMapper mapper;

    public CategoryController(CategoryRepository categoryRepository, CategoryService categoryService, CategoryMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity createCategory(@Valid @RequestBody CategoryDto.Create requestBody){
        Category category = mapper.categoryCreateDtoToCategory(requestBody);

        Category createdCatecory = categoryService.createCategory(category);
        URI location = UriCreator.createUri(CATEGORY_DEFAULT_URL, createdCatecory.getCategoryId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{category-id}")
    public ResponseEntity updateCategory (@PathVariable("category-id") @Positive Long categoryId,
                                          @Valid @RequestBody CategoryDto.Update requestBody){
        requestBody.setCategoryId(categoryId);

        Category category =
                categoryService.updateCategory(mapper.categoryUpdateDtoToCategory(requestBody));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.categoryToCategoryResponseDto(category)),
                HttpStatus.OK
        );
    }

    @GetMapping("/{category-id}")
    public ResponseEntity getCategory(@PathVariable("category-id") @Positive Long categoryId){
        Category category = categoryService.findCategory(categoryId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.categoryToCategoryResponseDto(category)),
                HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity getCategories(@Positive @RequestParam int page,
                                        @Positive @RequestParam int size){
        Page<Category> pageCategories = categoryService.findCategories(page-1, size);
        List<Category> categories = pageCategories.getContent();
        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.categoriesToCategoryResponseDtos(categories),
                        pageCategories), HttpStatus.OK
        );
    }

    @DeleteMapping("/{category-id}")
    public ResponseEntity deleteCategory(@PathVariable("category-id") @Positive Long categoryId){
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
