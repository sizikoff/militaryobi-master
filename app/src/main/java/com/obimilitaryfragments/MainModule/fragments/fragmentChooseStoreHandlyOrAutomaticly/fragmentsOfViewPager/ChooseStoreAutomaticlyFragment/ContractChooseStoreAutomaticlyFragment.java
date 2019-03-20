package com.obimilitaryfragments.MainModule.fragments.fragmentChooseStoreHandlyOrAutomaticly.fragmentsOfViewPager.ChooseStoreAutomaticlyFragment;

import android.app.Activity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.CitiesWithStores;

import java.util.ArrayList;

public interface ContractChooseStoreAutomaticlyFragment {

    interface Presenter{

        void onDestroy();
        void requestDataFromSystem();
        void getCoordinates();
        void moveTheGoogleMapToPresenter(GoogleMap googleMap);
    }

    interface MainView {
        void onResponseFailure(Throwable throwable);
        void showTheNavigatorsWays(Marker marker);
        void setTextToTextView(String name, String distance);
    }

    interface GetDataOfLocation {

        interface OnFinishedListener {
            void onFinished(CitiesWithStores citiesWithStores);
            void onFinishedCoordinates(String k);
            void onFailure(Throwable t);
        }

        void getArrayList(OnFinishedListener onFinishedListener);
    }

}
