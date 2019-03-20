package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog;

import android.util.Log;

import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOAkzii.ItemAkzii;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories.CategoriesOfStore;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories.Category;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.products.ProductsOfStore;
import com.obimilitaryfragments.commonClassesAndUtils.retrofit.RetrofitInstance;
import com.obimilitaryfragments.commonClassesAndUtils.retrofit.RetrofitNetwork;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model implements ContractFragmentCatalog.Model {

    private static final String TAG = "ModelFragmentCatalog";
    RetrofitNetwork service = RetrofitInstance.getRetrofitInstance().create(RetrofitNetwork.class);

    @Override
    public void getArrayListCatalog(final OnFinishedListenerCatalog onFinishedListener, final String nameStore, int obiStoreId) {

        String ask = "query { categories(obiStoreId:" + obiStoreId + ") { id name image root_id parent_id is_parent} }";

        Call<CategoriesOfStore> call = service.getCategoriesOfStore(ask);
        Log.i(TAG, call.request().url() + "");

        call.enqueue(new Callback<CategoriesOfStore>() {
            @Override
            public void onResponse(Call<CategoriesOfStore> call, Response<CategoriesOfStore> response) {
                CategoriesOfStore categoriesOfStore = response.body();
                onFinishedListener.onFinishedCatalog(categoriesOfStore);

                Log.i(TAG, "описание категории: " + categoriesOfStore.getDataThirdModule().getCategories().get(0).getName());
            }
            @Override
            public void onFailure(Call<CategoriesOfStore> call, Throwable t) {
                onFinishedListener.onFailureCatalog(t);
                Log.i(TAG, "ошибка: " + t.toString());
            }
        });
    }

    @Override
    public void getAkcii(final OnFinishedListenerAkcii onFinishedListenerAkcii, String nameStore, int obiStoreId) {

        Call<List<ItemAkzii>> call = service.getAkcii("");
        Log.i(TAG, "getAkcii: " + call.request().url() + "");

        call.enqueue(new Callback<List<ItemAkzii>>() {
            @Override
            public void onResponse(Call<List<ItemAkzii>> call, Response<List<ItemAkzii>> response) {
                ArrayList<ItemAkzii> itemAkziis = (ArrayList<ItemAkzii>) response.body();
                onFinishedListenerAkcii.onFinishedAkcii(itemAkziis);
                Log.i(TAG, "itemAkziis.get(2).getName(): " + itemAkziis.get(2).getName());
            }
            @Override
            public void onFailure(Call<List<ItemAkzii>> call, Throwable t) {
                Log.i(TAG, "ошибка: " + t.toString());
                onFinishedListenerAkcii.onFailureAkcii(t);
            }
        });

    }
}
