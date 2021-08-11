package com.example.uee_recipe_management.category;

public class MyModel {
    String title, description, date;
    int image;

    public MyModel(String title, String description, String date, int image) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }
    public String getDate() {
        return date;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
