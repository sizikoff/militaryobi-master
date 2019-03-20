package com.obimilitaryfragments.commonClassesAndUtils.database;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@android.arch.persistence.room.Dao
public interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAlbum(Album album);

    @Query("select * from album")
    List<Album> getAlbum();

    @Query("SELECT * FROM album WHERE id = :id")
    Album getById(String id);

    @Delete
    void deleteAlbum(Album album);

}
