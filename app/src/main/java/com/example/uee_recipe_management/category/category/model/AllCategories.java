package com.example.uee_recipe_management.category.category.model;

public class AllCategories {
    /**
     * Model class for the main recycle view adapter.
     * **/
    private String categoryName;

    public AllCategories(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
