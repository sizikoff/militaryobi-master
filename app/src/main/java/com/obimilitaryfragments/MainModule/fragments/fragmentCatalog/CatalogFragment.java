package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;

import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOAkzii.ItemAkzii;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories.Category;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.adapters.RecyclerAdapterCatalogFrag;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.adapters.RecyclerViewAdapterForAkzii;
import com.obimilitaryfragments.MainModule.fragments.fragmentSearch.FindFragment;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.Store;
import com.obimilitaryfragments.R;
import com.obimilitaryfragments.commonClassesAndUtils.database.DatabaseAsking;
import com.obimilitaryfragments.commonClassesAndUtils.database.MakingObjectsToStringAndBack;

import java.util.ArrayList;

public class CatalogFragment extends Fragment implements ContractFragmentCatalog.MainView{

    Presenter presenter;
    RecyclerView recyclerViewForCatalog, recyclerViewForAkcii, recyclerViewForPopular;
    private static final String TAG = "FragmentCatalog";
    Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //подгружаем магаз пользователя из базы данных
        Store usersStore = MakingObjectsToStringAndBack.stringToStore(DatabaseAsking.getSomeThing(String.valueOf(R.string.usersStoreDatabaseKey)));

        String storeName = usersStore.getName();
        int obiStoreId = usersStore.getObiStoreId();

        presenter = new Presenter(this, new Model(), context);
        presenter.requestCatalogFromServer(storeName, obiStoreId);
        presenter.getAkziiPresenter(storeName, obiStoreId);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog, null);
        TextView textView = view.findViewById(R.id.textViewInToolBarInFragCat);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FindFragment findFragment;
                findFragment = new FindFragment();
                loadFragment(findFragment);
            }
        });

        //ресайклер для каталога
        recyclerViewForCatalog = view.findViewById(R.id.recyclerViewInFragmentCatalogForCatalog);
        recyclerViewForCatalog.setLayoutManager(new LinearLayoutManager(context));
        recyclerViewForCatalog.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        //ресайклер для акций
        recyclerViewForAkcii = view.findViewById(R.id.recyclerViewInFragmentCatalogForAkcii);
        recyclerViewForAkcii.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewForAkcii.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        //ресайклер для популярного



        return view;
    }

    private  void loadFragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutMainAct, fragment).commit();
    }

    @Override
    public void setRecyclerViewCatalog(ArrayList<Category> productArray) {
        RecyclerView.Adapter adapter = new RecyclerAdapterCatalogFrag(getContext(), productArray, this);
        if (recyclerViewForCatalog != null) {
            recyclerViewForCatalog.setAdapter(adapter);
        }
        if (getContext() != null) {
            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.list_layout_controller);
            recyclerViewForCatalog.setLayoutAnimation(controller);
        }
    }

    @Override
    public void onResponseFailureCatalog(Throwable throwable) {
        Log.i(TAG, "onResponseFailure(Throwable throwable): " + throwable);
    }

    @Override
    public void sendCatalogToFragment(int pos, Category category, TextView textView, ImageView imageView){
        Log.i(TAG, "Mycategory.getName(): " + category.getName());
        presenter.onItemRecyclerViewCatalogClicked(pos, category, textView, imageView);
    }

    @Override
    public void setRecyclerWithAkzii(ArrayList<ItemAkzii> itemAkziis) {
        RecyclerViewAdapterForAkzii adapter = new RecyclerViewAdapterForAkzii(context, itemAkziis);
        recyclerViewForAkcii.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
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
