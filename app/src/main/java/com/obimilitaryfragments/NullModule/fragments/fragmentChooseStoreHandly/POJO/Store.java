package com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Store {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("obi_store_id")
    @Expose
    private Integer obiStoreId;
    @SerializedName("obi_store_id_prepared")
    @Expose
    private String obiStoreIdPrepared;
    @SerializedName("feed_version")
    @Expose
    private Integer feedVersion;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("city_id")
    @Expose
    private Integer cityId;
    @SerializedName("delivery")
    @Expose
    private Integer delivery;
    @SerializedName("order_and_take")
    @Expose
    private Integer orderAndTake;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("work_time")
    @Expose
    private String workTime;
    @SerializedName("rest_time")
    @Expose
    private String restTime;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("auto_map")
    @Expose
    private String autoMap;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;

    public Store(Integer id, Integer obiStoreId, String obiStoreIdPrepared, Integer feedVersion, String name, String description, Integer cityId, Integer delivery, Integer orderAndTake, String address, String email, String workTime, String restTime, String phone, String autoMap, Double lat, Double lng) {
        this.id = id;
        this.obiStoreId = obiStoreId;
        this.obiStoreIdPrepared = obiStoreIdPrepared;
        this.feedVersion = feedVersion;
        this.name = name;
        this.description = description;
        this.cityId = cityId;
        this.delivery = delivery;
        this.orderAndTake = orderAndTake;
        this.address = address;
        this.email = email;
        this.workTime = workTime;
        this.restTime = restTime;
        this.phone = phone;
        this.autoMap = autoMap;
        this.lat = lat;
        this.lng = lng;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getObiStoreId() {
        return obiStoreId;
    }

    public void setObiStoreId(Integer obiStoreId) {
        this.obiStoreId = obiStoreId;
    }

    public String getObiStoreIdPrepared() {
        return obiStoreIdPrepared;
    }

    public void setObiStoreIdPrepared(String obiStoreIdPrepared) {
        this.obiStoreIdPrepared = obiStoreIdPrepared;
    }

    public Integer getFeedVersion() {
        return feedVersion;
    }

    public void setFeedVersion(Integer feedVersion) {
        this.feedVersion = feedVersion;
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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public Integer getOrderAndTake() {
        return orderAndTake;
    }

    public void setOrderAndTake(Integer orderAndTake) {
        this.orderAndTake = orderAndTake;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getRestTime() {
        return restTime;
    }

    public void setRestTime(String restTime) {
        this.restTime = restTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAutoMap() {
        return autoMap;
    }

    public void setAutoMap(String autoMap) {
        this.autoMap = autoMap;
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

}