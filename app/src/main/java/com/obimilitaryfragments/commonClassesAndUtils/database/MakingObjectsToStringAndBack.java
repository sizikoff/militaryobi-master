package com.obimilitaryfragments.commonClassesAndUtils.database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.Store;

public class MakingObjectsToStringAndBack {

    public static Store stringToStore(String string) {
        Store store = new Gson().fromJson(string, new TypeToken<Store>() {}.getType());
        return store;
    }

    public static String storeToString(Store store) {
        String  string = new Gson().toJson(store);
        return string;
    }
}
