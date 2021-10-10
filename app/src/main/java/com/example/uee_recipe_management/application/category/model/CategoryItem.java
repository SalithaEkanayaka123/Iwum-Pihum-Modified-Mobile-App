package com.example.uee_recipe_management.application.category.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CategoryItem  implements Parcelable {
    /**
     * Model class for the nested recycle view adapter.
     * **/
    private String name;
    private Integer image;
    private String description;
    private String fireURL;
    private String subName;
    private String category;

    public CategoryItem(String name, String fireURL, String description, String subName, String category){

        try{
            // Null Validation
            if (name.trim().equals("")){
                name = "No Name";
            }
            // Null Validation
            if (fireURL.trim().equals("")){
                fireURL = "https://firebasestorage.googleapis.com/v0/b/uee-recipe-management.appspot.com/o/util%2Fnot_found_image.jpg?alt=media&token=cd8249f3-75c1-4a5a-976a-eb80206482ed";
            }
            // Null Validation
            if (description.trim().equals("")){
                description = "No Description";
            }
            // Null Validation
            if (subName.trim().equals("")){
                subName = "No SubName";
            }
            // Null Validation
            if (category.trim().equals("")){
                category = "No Category";
            }
        } catch (Exception e){
            System.out.println("Exception | CategoryItems | " + e.getMessage());
        }

        this.name = name;
        this.fireURL = fireURL;
        this.description = description;
        this.subName = subName;
        this.category = category;
    }

    public CategoryItem(String name, int image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public CategoryItem () {

    }

    protected CategoryItem(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0) {
            image = null;
        } else {
            image = in.readInt();
        }
        description = in.readString();
    }

    public static final Creator<CategoryItem> CREATOR = new Creator<CategoryItem>() {
        @Override
        public CategoryItem createFromParcel(Parcel in) {
            return new CategoryItem(in);
        }

        @Override
        public CategoryItem[] newArray(int size) {
            return new CategoryItem[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFireURL(){
        return fireURL;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        if (image == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(image);
        }
        parcel.writeString(description);
    }
}
