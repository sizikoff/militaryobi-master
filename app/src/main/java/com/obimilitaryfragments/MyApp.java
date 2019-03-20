package com.obimilitaryfragments;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.obimilitaryfragments.commonClassesAndUtils.database.DatabaseWithObjects;

public class MyApp extends Application {

    private static final String TAG = "MyApp";

    private DatabaseWithObjects databaseWithObjects;
    public static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        databaseWithObjects = Room.databaseBuilder(this, DatabaseWithObjects.class, "database").allowMainThreadQueries().build();

    }

    //синглтон базы данных
    public static MyApp getInstance() {
        return instance;
    }
    public DatabaseWithObjects getDatabaseWithObjects() {
        return databaseWithObjects;
    }
}
