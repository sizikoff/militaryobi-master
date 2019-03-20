package com.obimilitaryfragments.MainModule.fragments.fragmentSearch.POJOActFourFragOne;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("search")
    @Expose
    private Search search;

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }
}
