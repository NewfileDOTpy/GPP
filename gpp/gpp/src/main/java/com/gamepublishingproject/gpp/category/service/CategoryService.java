package com.gamepublishingproject.gpp.category.service;

import com.gamepublishingproject.gpp.category.exception.ExceptionCode;
import com.gamepublishingproject.gpp.category.entity.Category;
import com.gamepublishingproject.gpp.category.exception.BusinessLogicException;
import com.gamepublishingproject.gpp.category.repository.CategoryRepository;
import com.gamepublishingproject.gpp.category.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CustomBeanUtils<Category> beanUtils;

    public CategoryService(CategoryRepository categoryRepository, CustomBeanUtils<Category> beanUtils) {
        this.categoryRepository = categoryRepository;
        this.beanUtils = beanUtils;
    }

    public Category createCategory(Category category){
        Category response = category;
        return response;
    }

    public Category updateCategory(Category category){
        Category response = category;
        return response;
    }

    public Category findCategory(Long categoryId){
        return findVerifiedCategory(categoryId);
    }

    public Page<Category> findCategories(int page, int size){
        return categoryRepository.findAll(PageRequest.of(page, size, Sort.by("categoryId").descending()));
    }

    public void deleteCategory(Long categoryId){
        Category findCategory = findVerifiedCategory(categoryId);

        categoryRepository.delete(findCategory);
    }

    public Category findVerifiedCategory(Long categoryId){
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        Category findCategory =
                optionalCategory.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findCategory;
    }

    private void verifyExistCategory(String genre){
        Optional<Category> category = categoryRepository.findByGenre(genre);
        if(category.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
