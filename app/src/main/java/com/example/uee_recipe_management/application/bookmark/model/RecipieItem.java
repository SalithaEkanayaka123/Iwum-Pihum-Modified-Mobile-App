package com.example.uee_recipe_management.application.bookmark.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.uee_recipe_management.application.category.model.CategoryItem;

public class RecipieItem implements Parcelable {
    /**
     * Model class for the nested recycle view adapter.
     * **/
    private String name;
    private Integer image;
    private String description;
    private String fireURL;

    public RecipieItem(String name, String fireURL, String description){
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
        this.name = name;
        this.fireURL = fireURL;
        this.description = description;
    }

    public RecipieItem(String name, int image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    protected RecipieItem(Parcel in) {
        name = in.readString();
        if (in.readByte() == 0) {
            image = null;
        } else {
            image = in.readInt();
        }
        description = in.readString();
    }

    public static final Creator<RecipieItem> CREATOR = new Creator<RecipieItem>() {
        @Override
        public RecipieItem createFromParcel(Parcel in) {
            return new RecipieItem(in);
        }

        @Override
        public RecipieItem[] newArray(int size) {
            return new RecipieItem[size];
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

    public String getFireURL() {
        return fireURL;
    }

    public void setFireURL(String fireURL) {
        this.fireURL = fireURL;
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
