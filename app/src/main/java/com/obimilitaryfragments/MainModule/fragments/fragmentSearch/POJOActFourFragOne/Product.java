package com.obimilitaryfragments.MainModule.fragments.fragmentSearch.POJOActFourFragOne;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {

    @SerializedName("obi_id")
    @Expose
    private Integer obiId;
    @SerializedName("store_id")
    @Expose
    private Integer storeId;
    @SerializedName("barcode")
    @Expose
    private String barcode;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("images")
    @Expose
    private List<String> images = null;
    @SerializedName("existing_in_stores")
    @Expose
    private List<ExistingInStore> existingInStores = null;

    public Integer getObiId() {
        return obiId;
    }

    public void setObiId(Integer obiId) {
        this.obiId = obiId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<ExistingInStore> getExistingInStores() {
        return existingInStores;
    }

    public void setExistingInStores(List<ExistingInStore> existingInStores) {
        this.existingInStores = existingInStores;
    }

}
