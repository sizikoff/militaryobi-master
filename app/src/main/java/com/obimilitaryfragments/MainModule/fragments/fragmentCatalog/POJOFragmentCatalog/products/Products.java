package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Products {

    @SerializedName("items")
    @Expose
    private List<ItemOfProducts> items = null;

    public List<ItemOfProducts> getItems() {
        return items;
    }

    public void setItems(List<ItemOfProducts> items) {
        this.items = items;
    }
}
