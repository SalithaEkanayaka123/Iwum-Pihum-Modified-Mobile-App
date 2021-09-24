package com.example.uee_recipe_management.application.settings.model;

public class customButton1 {
    String songName;
    String path;

    public customButton1(String songName, String path) {
        this.songName = songName;
        this.path = path;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
