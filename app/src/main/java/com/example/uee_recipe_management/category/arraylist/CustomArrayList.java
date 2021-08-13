package com.example.uee_recipe_management.category.arraylist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.uee_recipe_management.category.MyModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

public class CustomArrayList {

    private ArrayList<MyModel> array = new ArrayList<>();

    public int size() {
        return 0;
    }


    public boolean isEmpty() {
        return false;
    }


    public int indexOf(@Nullable  Object o) {
        return 0;
    }


    public void add(int index, Object element) {
        //Add to the ArrayList
    }


    public Object remove(int index) {
        //Remove form the arraylist.
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
}
