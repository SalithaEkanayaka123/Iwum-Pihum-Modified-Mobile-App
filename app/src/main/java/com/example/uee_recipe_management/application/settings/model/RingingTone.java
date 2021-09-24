package com.example.uee_recipe_management.application.settings.model;

public class RingingTone {
    String title, path;

    public RingingTone(String title, String path) {
        this.title = title;
        this.path = path;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
