package com.example.uee_recipe_management.application.category.model;

import java.util.List;

public class AllCategories {
    /**
     * Model class for the main recycle view adapter.
     * **/
    private String categoryName;
    private List<CategoryItem> categoryItems;

    public AllCategories(String categoryName, List<CategoryItem> categoryItemList) {
        this.categoryName = categoryName;
        this.categoryItems = categoryItemList;

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<CategoryItem> getCategoryItems() {
        return categoryItems;
    }

    public void setCategoryItems(List<CategoryItem> categoryItems) {
        this.categoryItems = categoryItems;
    }
}
