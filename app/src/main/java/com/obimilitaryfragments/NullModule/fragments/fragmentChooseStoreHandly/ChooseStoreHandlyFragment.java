package com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.obimilitaryfragments.MainModule.MainActivity;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.Store;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.adapters.ExpandableListAdapter;
import com.obimilitaryfragments.R;
import com.obimilitaryfragments.commonClassesAndUtils.database.DatabaseAsking;
import com.obimilitaryfragments.commonClassesAndUtils.database.MakingObjectsToStringAndBack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChooseStoreHandlyFragment extends Fragment implements ContractChooseStoreHandlyFragment.MainView {

    private static final String TAG = "ChooseStoreHandFrag";
    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;

    Context context;
    ContractChooseStoreHandlyFragment.Presenter presenter;
    ArrayList<String> header;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new Presenter(this, new Model(), getContext());
        presenter.requestDataFromServer();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose_store_handly, container, false);
        expandableListView = view.findViewById(R.id.expandableListViewInChooseStoreHandlyFragment);
        expandableListView.setGroupIndicator(null);
        return view;
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

    @Override
    public void setItemsToListView(ArrayList<String> myCities, HashMap<String, List<Store>> myChildren) {
        // Array list for header
        header = new ArrayList<String>();
        header.addAll(myCities);
        adapter = new ExpandableListAdapter(getContext(), header, myChildren);
        // Setting adpater over expandablelistview
        expandableListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        setListener();
    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }

    private void setListener() {
        // This listener will show toast on group click
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView listview, View view, int group_pos, long id) {
                return false;
            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            // Default position
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)

                    // Collapse the expanded group
                expandableListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });

        // This listener will show toast on child click
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView listview, View view, int groupPos, int childPos, long id) {

                Store clickedStore = (Store) listview.getExpandableListAdapter().getChild(groupPos, childPos);
                Log.i(TAG, "clickedStore: " + clickedStore.getName());

                //сохраняем магаз пользователя в базу данных
                DatabaseAsking.insertSomeThing(String.valueOf(R.string.usersStoreDatabaseKey), MakingObjectsToStringAndBack.storeToString(clickedStore));
                Toast.makeText(getContext(), "Ваш магазин: " + clickedStore.getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                return false;
            }
        });
    }
}
