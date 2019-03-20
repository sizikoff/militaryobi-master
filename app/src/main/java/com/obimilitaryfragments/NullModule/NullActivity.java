package com.obimilitaryfragments.NullModule;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.obimilitaryfragments.NullModule.fragments.IncommingFragment.IncommingFragment;
import com.obimilitaryfragments.R;

public class NullActivity extends AppCompatActivity {

    private static final String TAG = "NullActivity";
    IncommingFragment incommingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_null);

        incommingFragment = new IncommingFragment();
        loadFragment(incommingFragment);
    }

    private  void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutNullAct, fragment).commit();
    }
}
