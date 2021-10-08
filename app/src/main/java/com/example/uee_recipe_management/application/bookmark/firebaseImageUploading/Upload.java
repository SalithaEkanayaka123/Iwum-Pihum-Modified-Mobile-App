package com.example.uee_recipe_management.application.bookmark.firebaseImageUploading;

public class Upload {
    private String name;
    private String subName;
    private String imageUrl;
    private String description;

    public Upload(String name, String subName, String imageUrl, String description) {
        this.name = name;
        this.subName = subName;
        this.imageUrl = imageUrl;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
