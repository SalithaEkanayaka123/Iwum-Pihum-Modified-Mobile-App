package com.example.uee_recipe_management.application.settings.model;

public class customButton1 {
    String title1, String2;
    Boolean status;

    public customButton1(String title1, String string2, Boolean status) {
        this.title1 = title1;
        String2 = string2;
        this.status = status;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getString2() {
        return String2;
    }

    public void setString2(String string2) {
        String2 = string2;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
