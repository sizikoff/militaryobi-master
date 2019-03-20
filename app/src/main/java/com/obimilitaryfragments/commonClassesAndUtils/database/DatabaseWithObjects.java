package com.obimilitaryfragments.commonClassesAndUtils.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Album.class}, version = 1)
public abstract class DatabaseWithObjects extends RoomDatabase {
    public abstract Dao getDao();
}
