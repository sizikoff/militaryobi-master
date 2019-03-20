package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Category {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("root_id")
    @Expose
    private Integer rootId;

    @SerializedName("parent_id")
    @Expose
    private Integer parentId;

    @SerializedName("is_parent")
    @Expose
    private Integer isParent;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public Integer getRootId() {
        return rootId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Integer getIsParent() {
        return isParent;
    }

    public void setName(String name) {
        this.name = name;
    }
}
