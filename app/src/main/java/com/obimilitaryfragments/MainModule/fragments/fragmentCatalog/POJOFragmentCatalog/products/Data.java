package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("products")
    @Expose
    private Products products;

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
