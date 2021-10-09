package com.example.uee_recipe_management.application.bookmark.firebaseImageUploading;

public class Upload {
    private String name;
    private String subName;
    private String imageUrl;
    private String description;
    private String category;
    private boolean state;

    // New Text Fields.
    // bookmark state
    // category

    public Upload(){

    }

    public Upload(String name, String subName, String imageUrl, String description, String category) {
        // Null Validation
        if (name.trim().equals("")){
            name = "No Name";
        }
        this.name = name;
        this.subName = subName;
        this.imageUrl = imageUrl;
        this.description = description;
        this.category = category;
        this.state = false;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
