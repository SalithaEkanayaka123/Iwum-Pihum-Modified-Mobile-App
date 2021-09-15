package com.example.uee_recipe_management.application.settings.model;

public class customButton1 {
    String title1, title2;
    Boolean status;

    public customButton1(String title1, String title2, Boolean status) {
        this.title1 = title1;
        title2 = title2;
        this.status = status;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        title2 = title2;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
