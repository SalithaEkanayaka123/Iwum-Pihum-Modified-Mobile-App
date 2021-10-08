package com.example.uee_recipe_management.application.item.adapter;

public class SimilarItem {
    private String name;
    private String subheader;
    private int thumbnail;

    public SimilarItem(String name, String subheader, int thumbnail) {
        this.name = name;
        this.subheader = subheader;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubheader() {
        return subheader;
    }

    public void setSubheader(String subheader) {
        this.subheader = subheader;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
