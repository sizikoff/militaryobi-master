package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.products;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductsOfStore {

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
