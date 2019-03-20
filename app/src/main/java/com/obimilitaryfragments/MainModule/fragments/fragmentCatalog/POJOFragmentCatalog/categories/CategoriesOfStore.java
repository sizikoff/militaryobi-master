package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoriesOfStore {

    @SerializedName("data")
    @Expose
    private DataThirdModule dataThirdModule;

    public DataThirdModule getDataThirdModule() {
        return dataThirdModule;
    }
}
