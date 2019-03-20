package com.obimilitaryfragments.MainModule.fragments.fragmentOthers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.obimilitaryfragments.MainModule.fragments.fragmentChooseStoreHandlyOrAutomaticly.ChooseStoreHandlyOrAutomaticlyFragment;
import com.obimilitaryfragments.MainModule.fragments.fragmentSearch.FindFragment;
import com.obimilitaryfragments.R;

public class OthersFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_others, null);

        Button buttonFind = view.findViewById(R.id.btnFindInFragOthers);
        buttonFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindFragment findFragment;
                findFragment = new FindFragment();
                loadFragment(findFragment);
            }
        });

        Button buttonMap = view.findViewById(R.id.btnMapInFragOthers);
        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(ChooseStoreHandlyOrAutomaticlyFragment.newInstance(""));
            }
        });
        return view;
    }

    private  void loadFragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMainAct, fragment).addToBackStack(null).commit();
    }
}
