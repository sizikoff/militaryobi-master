package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOAkzii;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemAkzii {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("preview_text")
    @Expose
    private String previewText;
    @SerializedName("detail_text")
    @Expose
    private String detailText;
    @SerializedName("red_text")
    @Expose
    private Object redText;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("old_price")
    @Expose
    private String oldPrice;
    @SerializedName("super_price")
    @Expose
    private int superPrice;
    @SerializedName("details_link")
    @Expose
    private Object detailsLink;
    @SerializedName("board_id")
    @Expose
    private Object boardId;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("small_image")
    @Expose
    private String smallImage;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("is_notify")
    @Expose
    private int isNotify;
    @SerializedName("notify_text")
    @Expose
    private String notifyText;
    @SerializedName("show_on_main")
    @Expose
    private int showOnMain;
    @SerializedName("stores")
    @Expose
    private List<Store> stores = null;
    @SerializedName("cities")
    @Expose
    private List<City> cities = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreviewText() {
        return previewText;
    }

    public void setPreviewText(String previewText) {
        this.previewText = previewText;
    }

    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    public Object getRedText() {
        return redText;
    }

    public void setRedText(Object redText) {
        this.redText = redText;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getSuperPrice() {
        return superPrice;
    }

    public void setSuperPrice(int superPrice) {
        this.superPrice = superPrice;
    }

    public Object getDetailsLink() {
        return detailsLink;
    }

    public void setDetailsLink(Object detailsLink) {
        this.detailsLink = detailsLink;
    }

    public Object getBoardId() {
        return boardId;
    }

    public void setBoardId(Object boardId) {
        this.boardId = boardId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getIsNotify() {
        return isNotify;
    }

    public void setIsNotify(int isNotify) {
        this.isNotify = isNotify;
    }

    public String getNotifyText() {
        return notifyText;
    }

    public void setNotifyText(String notifyText) {
        this.notifyText = notifyText;
    }

    public int getShowOnMain() {
        return showOnMain;
    }

    public void setShowOnMain(int showOnMain) {
        this.showOnMain = showOnMain;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }


}
