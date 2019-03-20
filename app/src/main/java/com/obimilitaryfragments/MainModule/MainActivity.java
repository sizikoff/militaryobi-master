package com.obimilitaryfragments.MainModule;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.obimilitaryfragments.MainModule.fragments.fragmentBusket.BusketFragment;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.CatalogFragment;
import com.obimilitaryfragments.MainModule.fragments.fragmentHome.HomeFragment;
import com.obimilitaryfragments.MainModule.fragments.fragmentMap.MapFragment;
import com.obimilitaryfragments.MainModule.fragments.fragmentOthers.OthersFragment;
import com.obimilitaryfragments.NullModule.NullActivity;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.Store;
import com.obimilitaryfragments.R;
import com.obimilitaryfragments.commonClassesAndUtils.database.DatabaseAsking;
import com.obimilitaryfragments.commonClassesAndUtils.database.MakingObjectsToStringAndBack;

public class MainActivity extends AppCompatActivity {

    CatalogFragment catalogFragment;
    HomeFragment homeFragment;
    BusketFragment busketFragment;
    MapFragment mapFragment;
    OthersFragment othersFragment;

    Store usersStore;

    BottomNavigationView navigation;

    private static final String TAG = "MainActivity";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_main:
                    homeFragment = new HomeFragment();
                    loadFragment(homeFragment);
                    return true;
                case R.id.navigation_find:
                    catalogFragment = new CatalogFragment();
                    loadFragment(catalogFragment);
                    return true;
                case R.id.navigation_map:
                    mapFragment = new MapFragment();
                    loadFragment(mapFragment);
                    return true;
                case R.id.navigation_busket:
                    busketFragment = new BusketFragment();
                    loadFragment(busketFragment);
                    return true;
                case R.id.navigation_other:
                    othersFragment = new OthersFragment();
                    loadFragment(othersFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (DatabaseAsking.getSomeThing(String.valueOf(R.string.usersStoreDatabaseKey)) == null) {
            Intent intent = new Intent(this, NullActivity.class);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.activity_main);

            navigation = (BottomNavigationView) findViewById(R.id.navigationMainAct);
            navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

            homeFragment = new HomeFragment();
            loadFragment(homeFragment);

            usersStore = MakingObjectsToStringAndBack.stringToStore(DatabaseAsking.getSomeThing(String.valueOf(R.string.usersStoreDatabaseKey)));
            Log.i(TAG, "store.getName(): " + usersStore.getName());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
       // navigation.getMenu().getItem(0).setChecked(true);
    }

    private  void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMainAct, fragment).commit();
    }


    long back_pressed;
    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            if (back_pressed + 1500 > System.currentTimeMillis()) {
                super.onBackPressed();
            } else {
                Toast.makeText(getBaseContext(), "нажмите еще раз для выхода", Toast.LENGTH_SHORT).show();
            }
            back_pressed = System.currentTimeMillis();
        }

        if (getSupportFragmentManager().getBackStackEntryCount()>=1) {
            super.onBackPressed();
        }
    }
}
