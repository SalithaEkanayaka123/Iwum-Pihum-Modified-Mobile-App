package com.example.uee_recipe_management.application.category.model;

public class CategoryItem {
    /**
     * Model class for the nested recycle view adapter.
     * **/
    private String name;
    private Integer image;
    private String description;

    public CategoryItem(String name, int image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
