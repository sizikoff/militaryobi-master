package com.obimilitaryfragments.MainModule.fragments.fragmentChooseStoreHandlyOrAutomaticly.fragmentsOfViewPager.ChooseStoreAutomaticlyFragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Parcel;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.obimilitaryfragments.MainModule.fragments.fragmentChooseStoreHandlyOrAutomaticly.fragmentsOfViewPager.ChooseStoreAutomaticlyFragment.POJO.NearestStore;
import com.obimilitaryfragments.MainModule.fragments.fragmentChooseStoreHandlyOrAutomaticly.fragmentsOfViewPager.ChooseStoreAutomaticlyFragment.utils.HaversineAlgorithm;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.CitiesWithStores;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.City;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.Store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressLint("LongLogTag")
public class Presenter implements ContractChooseStoreAutomaticlyFragment.Presenter, ContractChooseStoreAutomaticlyFragment.GetDataOfLocation.OnFinishedListener {

    private static final String TAG = "PresenterChooseStoreAutomaticlyFragment";
    private ContractChooseStoreAutomaticlyFragment.MainView mainView;
    private ContractChooseStoreAutomaticlyFragment.GetDataOfLocation getDataOfLocation;
    Context context;
    CitiesWithStores citiesWithStores;
    ArrayList<Store> stores = new ArrayList<>();

    GoogleMap googleMap;
    LatLng usersLatLng;
    int count = 0;

    public Presenter(ContractChooseStoreAutomaticlyFragment.MainView mainView, ContractChooseStoreAutomaticlyFragment.GetDataOfLocation getDataOfLocation, Context context) {
        this.mainView = mainView;
        this.getDataOfLocation = getDataOfLocation;
        this.context = context;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void requestDataFromSystem() {

    }

    //получаем список координат всех магазинов во всех городах (28 штук где то их)
    @Override
    public void onFinished(CitiesWithStores citiesWithStores) {

        this.citiesWithStores = citiesWithStores;

        ArrayList<City> cities = (ArrayList<City>) citiesWithStores.getData().getCities();
        ArrayList<Store> myStores;

        if (stores.size() > 0)
            stores.clear();

        for (int i = 0; i < cities.size(); i++) {
            myStores = (ArrayList<Store>) cities.get(i).getStores();
            stores.addAll(myStores);
        }
        Log.i(TAG, "stores.size(): " + stores.size());

        ArrayList<LatLng> arrayLatLng = getTheArrayOfStoreCoordinates(stores);

        for (int i = 0; i < stores.size(); i++) {
            MarkerOptions markerOptions = new MarkerOptions().position(arrayLatLng.get(i)).title(stores.get(i).getName());
            googleMap.addMarker(markerOptions);
        }

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                mainView.showTheNavigatorsWays(marker);
                return false;
            }
        });
    }

    private ArrayList<LatLng> getTheArrayOfStoreCoordinates(ArrayList<Store> stores) {
        ArrayList<LatLng> arrayLatLng = new ArrayList<>();

        LatLng latLng = null;
        for (int i = 0; i < stores.size(); i++) {
            latLng = new LatLng(stores.get(i).getLat(), stores.get(i).getLng());
            arrayLatLng.add(latLng);
        }
        return arrayLatLng;
    }


    //получаем наши координаты
    @SuppressLint("MissingPermission")
    @Override
    public void onFinishedCoordinates(String k) {
        Log.i(TAG, "onFinishedCoordinates(String k): " + k);

        double myLat = Double.parseDouble(k.substring(0, k.indexOf(" ")));
        double myLong = Double.parseDouble(k.substring(k.indexOf(" ")));
        Log.i(TAG, "myLat: " + myLat + "; " + "myLong: " + myLong);

        usersLatLng = new LatLng(myLat, myLong);

        if (count == 0 && googleMap != null) {
            //нарпавляем камеру на место юзера
            CameraPosition cameraPosition = new CameraPosition.Builder().target(usersLatLng).zoom(12).bearing(180).tilt(20).build();
            CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
            googleMap.animateCamera(cameraUpdate);

            //добавляем юзера
            googleMap.setMyLocationEnabled(true);
            count++;
        }

        String name = getStoreWithMinimumDistance(myLat, myLong).getName();
        String distance = String.format("%.2f", getStoreWithMinimumDistance(myLat, myLong).getDistance());

        Log.i(TAG, "Ближайший магаз: " + name + "; расстояние: " + distance + "км");
        mainView.setTextToTextView(name, distance);

    }

    //функция которая сравнивает все дистанции, находит минимальную и возвращает название магаза с минимальной дистанцией
    private NearestStore getStoreWithMinimumDistance(double myLatitude, double myLongtitude) {
        ArrayList<Double> distances = new ArrayList<>();
        Double d = Double.valueOf(0);
        String nameOfNearestStore = "";
        if (stores != null) {
            for (int i = 0; i < stores.size(); i++) {
                double storeLat = stores.get(i).getLat();
                double storeLon = stores.get(i).getLng();
                double distance = HaversineAlgorithm.HaversineInKM(myLatitude, myLongtitude, storeLat, storeLon);
                distances.add(distance);
                Log.i(TAG, "distance: " + distance);
                d = Collections.min(distances);
                Log.i(TAG, "Double d: " + d);
                if (distance == d) {
                    nameOfNearestStore = stores.get(i).getName();
                }
            }
            Log.i(TAG, "nameOfNearestStore: " + nameOfNearestStore);
        }
        NearestStore nearestStore = new NearestStore();
        nearestStore.setName(nameOfNearestStore);
        nearestStore.setDistance(d);
        return nearestStore;
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
        }
    }

    @Override
    public void getCoordinates() {
        ModelCoordinats modelCoordinats = new ModelCoordinats(context);
        modelCoordinats.getLocation(this);
    }

    @Override
    public void moveTheGoogleMapToPresenter(GoogleMap googleMap) {
        this.googleMap = googleMap;

        getDataOfLocation.getArrayList(this);

        Log.i(TAG, "moveTheGoogleMapToPresenter: done");
    }
}
