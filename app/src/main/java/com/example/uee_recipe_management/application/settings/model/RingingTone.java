package com.example.uee_recipe_management.application.settings.model;

public class RingingTone {
    String title;
    int path;

    public RingingTone(String title, int path) {
        this.title = title;
        this.path = path;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }
}
