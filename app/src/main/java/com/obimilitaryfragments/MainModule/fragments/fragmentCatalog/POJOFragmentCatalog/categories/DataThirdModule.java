package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataThirdModule {

    @SerializedName("categories")
    @Expose
    private ArrayList<Category> categories = null;

    public ArrayList<Category> getCategories() {
        return categories;
    }
}
