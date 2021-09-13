package com.example.uee_recipe_management.category.category.model;

public class CategoryItem {
    /**
     * Model class for the nested recycle view adapter.
     * **/
    private String name;
    private String image;
    private String description;

    public CategoryItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
