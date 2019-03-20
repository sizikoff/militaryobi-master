package com.obimilitaryfragments.NullModule.fragments.IncommingFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.obimilitaryfragments.MainModule.fragments.fragmentChooseStoreHandlyOrAutomaticly.ChooseStoreHandlyOrAutomaticlyFragment;
import com.obimilitaryfragments.R;

public class IncommingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_incomming, null);
        Button button = view.findViewById(R.id.buttonGetStoreHandly);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChooseStoreHandlyOrAutomaticlyFragment chooseStoreHandlyOrAutomaticlyFragment = new ChooseStoreHandlyOrAutomaticlyFragment();
                loadFragment(chooseStoreHandlyOrAutomaticlyFragment);
            }
        });
        return view;
    }

    private  void loadFragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutNullAct, fragment).commit();
    }
}
