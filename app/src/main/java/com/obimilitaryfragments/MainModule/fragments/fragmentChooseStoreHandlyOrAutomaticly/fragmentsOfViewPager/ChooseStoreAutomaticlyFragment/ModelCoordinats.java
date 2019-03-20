package com.obimilitaryfragments.MainModule.fragments.fragmentChooseStoreHandlyOrAutomaticly.fragmentsOfViewPager.ChooseStoreAutomaticlyFragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import static android.content.Context.LOCATION_SERVICE;
import static android.location.LocationManager.NETWORK_PROVIDER;

public class ModelCoordinats implements ContractChooseStoreAutomaticlyFragment.GetDataOfLocation{

    private static final String TAG = "ModelCoordinats";
    Context mContext;
    String s;


    public ModelCoordinats(Context mContext) {
        this.mContext = mContext;
    }

    public String getLocation(final OnFinishedListener onFinishedListener) {
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i(TAG, "onLocationChanged: " + location.toString());
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                Log.i(TAG, "latitude: " + latitude);
                Log.i(TAG, "longitude: " + longitude);
                s = String.valueOf(latitude) + " " + String.valueOf(longitude);
                onFinishedListener.onFinishedCoordinates(s);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
            }
        };
        LocationManager locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return null;
        }
        locationManager.requestLocationUpdates(NETWORK_PROVIDER, 1000, 0, locationListener);

        return s;
    }

    @Override
    public void getArrayList(OnFinishedListener onFinishedListener) {

    }
}


