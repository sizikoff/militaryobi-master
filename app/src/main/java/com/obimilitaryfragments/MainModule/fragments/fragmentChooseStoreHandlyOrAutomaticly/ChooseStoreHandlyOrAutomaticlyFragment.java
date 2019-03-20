package com.obimilitaryfragments.MainModule.fragments.fragmentChooseStoreHandlyOrAutomaticly;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.obimilitaryfragments.MainModule.fragments.fragmentChooseStoreHandlyOrAutomaticly.fragmentsOfViewPager.ChooseStoreAutomaticlyFragment.ChooseStoreAutomaticlyFragment;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.ChooseStoreHandlyFragment;
import com.obimilitaryfragments.R;

public class ChooseStoreHandlyOrAutomaticlyFragment extends Fragment {

    Context context;
    public static final String TAG = "ChStoHandOrAutoFrag";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_store_handly_or_automaticly, null);

        ViewPager pager = view.findViewById(R.id.viewPagerInFragChooseStoreTwoWays);
        pager.setAdapter(new MyPagerAdapter(getActivity().getSupportFragmentManager()));


        return view;
    }

    public static ChooseStoreHandlyOrAutomaticlyFragment newInstance(String text) {
        ChooseStoreHandlyOrAutomaticlyFragment f = new ChooseStoreHandlyOrAutomaticlyFragment();
        return f;
    }

    // Adapter
    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "карта";
                case 1:
                    return "список";
                default: return null;
            }
        }

        @Override
        public Fragment getItem(int pos) {

            switch (pos){
                case 0: return ChooseStoreAutomaticlyFragment.newInstance("ChooseStoreAutomaticlyFragment, Instance 1");
                case 1: return new ChooseStoreHandlyFragment(); //этот фрагмент взят из нулевого модуля
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        context = null;
    }
}
