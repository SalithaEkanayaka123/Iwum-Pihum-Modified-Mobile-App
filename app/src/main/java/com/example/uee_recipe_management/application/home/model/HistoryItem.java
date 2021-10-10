package com.example.uee_recipe_management.application.home.model;

import com.example.uee_recipe_management.application.category.model.CategoryItem;

import java.util.Date;

public class HistoryItem  {

    String date;
    private String name;
    private String description;
    private String fireURL;
    private String subName;
    private String category;

    public HistoryItem() {

    }

    public HistoryItem(String date, String name, String description, String fireURL, String subName, String category) {
        this.date = date;
        this.name = name;
        this.description = description;
        this.fireURL = fireURL;
        this.subName = subName;
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFireURL() {
        return fireURL;
    }

    public void setFireURL(String fireURL) {
        this.fireURL = fireURL;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
