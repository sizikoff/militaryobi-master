package com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {


    @SerializedName("cities")
    @Expose
    public List<City> cities = null;

    public Data(List<City> cities) {
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

}
