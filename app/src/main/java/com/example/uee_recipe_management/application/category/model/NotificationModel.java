package com.example.uee_recipe_management.application.category.model;
/**
 * Notification Model class
 * Notification are saved in the database.
 * Multitype
 * **/


public class NotificationModel {
    private String name;
    private String subheading;
    private String type;

    public NotificationModel(String name, String subheading, String type) {
        this.name = name;
        this.subheading = subheading;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubheading() {
        return subheading;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
