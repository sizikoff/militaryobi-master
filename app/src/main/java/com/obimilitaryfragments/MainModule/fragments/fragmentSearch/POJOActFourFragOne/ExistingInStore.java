package com.obimilitaryfragments.MainModule.fragments.fragmentSearch.POJOActFourFragOne;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExistingInStore {

    @SerializedName("store_id")
    @Expose
    private Integer storeId;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
