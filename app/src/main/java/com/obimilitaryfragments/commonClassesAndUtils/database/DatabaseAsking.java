package com.obimilitaryfragments.commonClassesAndUtils.database;


import com.obimilitaryfragments.MyApp;

public class DatabaseAsking {

    public static void insertSomeThing(String id, String anyString){

        DatabaseWithObjects databaseWithObjects = MyApp.getInstance().getDatabaseWithObjects();
        Dao dao = databaseWithObjects.getDao();

        Album album = new Album(id, anyString);
        dao.insertAlbum(album);
    }

    public static String getSomeThing(String id) {

        DatabaseWithObjects databaseWithObjects = MyApp.getInstance().getDatabaseWithObjects();
        Dao dao = databaseWithObjects.getDao();

        if (dao.getById(id) == null) {
            return null;
        } else {
            String s = dao.getById(id).getAnyString();
            return s;
        }
    }
}
