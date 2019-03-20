package com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly;

import android.content.Context;
import android.util.Log;

import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.ContractChooseStoreHandlyFragment;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.CitiesWithStores;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.City;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Presenter implements ContractChooseStoreHandlyFragment.Presenter, ContractChooseStoreHandlyFragment.Model.OnFinishedListener {

    private static final String TAG = "PresenterModuleTwo";
    private ContractChooseStoreHandlyFragment.MainView mainView;
    private ContractChooseStoreHandlyFragment.Model model;
    Context context;
    CitiesWithStores citiesWithStores;

    public Presenter(ContractChooseStoreHandlyFragment.MainView mainView, ContractChooseStoreHandlyFragment.Model getNoticeIntractor, Context context) {
        this.mainView = mainView;
        this.model = getNoticeIntractor;
        this.context = context;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void requestDataFromServer() {
        model.getArrayList(this);
    }

    @Override
    public void onFinished(CitiesWithStores citiesWithStores) {
        Log.i(TAG, "onFinished(citiesWithStores.getData().getCities().get(0).getName()): " +citiesWithStores.getData().getCities().get(0).getName());

        this.citiesWithStores = citiesWithStores;

        ArrayList<City> cities = (ArrayList<City>) citiesWithStores.getData().getCities();
        ArrayList<String> myCities = new ArrayList<>();

        for (int i = 0; i < cities.size(); i++) {
            myCities.add(cities.get(i).getName());
        }

        HashMap<String, List<Store>> hashMap = new HashMap<String, List<Store>>();

        for (int i = 0; i < cities.size(); i++) {
            hashMap.put(cities.get(i).getName(), cities.get(i).getStores());
        }

        mainView.setItemsToListView(myCities, hashMap);
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
        }
    }
}
