package com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class City {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("mapzoom")
    @Expose
    private Integer mapzoom;
    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("stores")
    @Expose
    private List<Store> stores = null;

    public City(Integer id, String name, Double lat, Double lng, Integer mapzoom, String code, List<Store> stores) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.mapzoom = mapzoom;
        this.code = code;
        this.stores = stores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Integer getMapzoom() {
        return mapzoom;
    }

    public void setMapzoom(Integer mapzoom) {
        this.mapzoom = mapzoom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

}
