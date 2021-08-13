package com.example.uee_recipe_management.category.CustomArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.uee_recipe_management.category.MyModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

public class CustomArrayList {

    //Singleton Class Instance.
    static CustomArrayList singleInstance = null;

    //Private Constructor.
    private CustomArrayList() {}

    private ArrayList<MyModel> array = new ArrayList<>();

    //Singleton Instance Fetching method.
    public static CustomArrayList getInstance(){
        if(singleInstance == null){
            singleInstance = new CustomArrayList();
        }
        return singleInstance;
    }

    public int size() {
        return 0;
    }


    public boolean isEmpty() {
        return false;
    }


    public int indexOf(@Nullable  Object o) {
        return 0;
    }


    public void add(MyModel object) {
       array.add(object);
    }


    public Object remove(MyModel object, @Nullable String name) {
       array.remove(object);
       return null;
    }


    public void forEach(@NonNull  Consumer action) {
        //Run the loop
    }


    public void sort(@Nullable Comparator c) {
        //Sorting logic of the Arraylist.
    }


    public String toString() {
        return super.toString();
    }

    public ArrayList<MyModel> getArray(){
        return array;
    }
}
