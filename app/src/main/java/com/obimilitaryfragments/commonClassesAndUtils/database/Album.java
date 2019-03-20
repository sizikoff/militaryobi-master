package com.obimilitaryfragments.commonClassesAndUtils.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Album {

    @PrimaryKey
    @NonNull
    private String id;
    private String anyString;

    public Album(@NonNull String id, String anyString) {
        this.id = id;
        this.anyString = anyString;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getAnyString() {
        return anyString;
    }

    public void setAnyString(String anyString) {
        this.anyString = anyString;
    }
}
