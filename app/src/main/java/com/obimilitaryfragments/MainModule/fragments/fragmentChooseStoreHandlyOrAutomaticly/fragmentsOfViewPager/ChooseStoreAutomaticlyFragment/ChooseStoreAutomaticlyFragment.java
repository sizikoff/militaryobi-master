package com.obimilitaryfragments.MainModule.fragments.fragmentChooseStoreHandlyOrAutomaticly.fragmentsOfViewPager.ChooseStoreAutomaticlyFragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.obimilitaryfragments.R;

import java.util.ArrayList;


public class ChooseStoreAutomaticlyFragment extends Fragment implements OnMapReadyCallback, ContractChooseStoreAutomaticlyFragment.MainView {

    public GoogleMap googleMap = null;
    private MapView mapView;
    public static final String TAG = "ChooseStoreAutomaticlyFragmentk";
    private ContractChooseStoreAutomaticlyFragment.Presenter presenter;
    public static final int REQUEST_CODE_GET_ACCSES_LOCATION = 013542;
    TextView textView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        presenter = new Presenter(this, new Model(), getContext());
        askPermissionLocation();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_store_automaticly_in_view_pager, null);
        textView = view.findViewById(R.id.textViewInFragChooseStoreAuto);
        textView.setVisibility(View.INVISIBLE);
        mapView = view.findViewById(R.id.viewMapInFragChooseStoreAuto);
        mapView.getMapAsync(this);
        mapView.onCreate(getArguments());
        return view;
    }

    public static ChooseStoreAutomaticlyFragment newInstance(String text) {

        ChooseStoreAutomaticlyFragment f = new ChooseStoreAutomaticlyFragment();
//        Bundle b = new Bundle();
//        b.putString("msg", text);
//        f.setArguments(b);
        return f;
    }


    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;

        presenter.moveTheGoogleMapToPresenter(googleMap);
        presenter.requestDataFromSystem();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mapView != null)
            mapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mapView != null)
            mapView.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mapView != null)
            mapView.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mapView != null)
            mapView.onStop();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mapView != null)
            mapView.onSaveInstanceState(outState);
    }

    //запрашиваем у юзера разрешение
    private void askPermissionLocation() {
        int permissionStatus = ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionStatus == PackageManager.PERMISSION_GRANTED) {
            presenter.getCoordinates();
        } else {
            this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_GET_ACCSES_LOCATION);
        }

    }

    //а в этом методе видно, дано разрешение на местоположение или нет
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                switch (requestCode){
            case REQUEST_CODE_GET_ACCSES_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    presenter.getCoordinates();
                } else {
                    Toast.makeText(getContext(), "без разрешения работа карты не возможна", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Log.i(TAG, "ошибка: " + throwable);
    }

    @Override
    public void showTheNavigatorsWays(Marker marker) {

        Uri uri = Uri.parse("geo:0,0?q=" + marker.getPosition().latitude + "," + marker.getPosition().longitude  );
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        this.startActivity(intent);

        Log.i(TAG, "uri: " + uri);
    }

    @Override
    public void setTextToTextView(String name, String distance) {
        textView.setVisibility(View.VISIBLE);
        textView.setText("Ближайший магазин: " + name + "; расстояние: " + distance + "км.");
    }
}
