package com.obimilitaryfragments.MainModule.fragments.fragmentChooseStoreHandlyOrAutomaticly.fragmentsOfViewPager.ChooseStoreAutomaticlyFragment;

import android.util.Log;

import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.CitiesWithStores;
import com.obimilitaryfragments.commonClassesAndUtils.retrofit.RetrofitInstance;
import com.obimilitaryfragments.commonClassesAndUtils.retrofit.RetrofitNetwork;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Model implements ContractChooseStoreAutomaticlyFragment.GetDataOfLocation {

    private static final String TAG = "ModelModuleOne";

    @Override
    public void getArrayList(final OnFinishedListener onFinishedListener) {

        RetrofitNetwork service = RetrofitInstance.getRetrofitInstance().create(RetrofitNetwork.class);
        Call<CitiesWithStores> call = service.getCitiesWithStores();
        Log.i("URL Called", call.request().url() + "");

        call.enqueue(new Callback<CitiesWithStores>() {
            @Override
            public void onResponse(Call<CitiesWithStores> call, Response<CitiesWithStores> response) {
                CitiesWithStores  citiesWithStores = response.body();

                onFinishedListener.onFinished(citiesWithStores);
                Log.i(TAG, "описание магазина: ");
            }
            @Override
            public void onFailure(Call<CitiesWithStores> call, Throwable t) {
                onFinishedListener.onFailure(t);
                Log.i(TAG, "ошибка: " + t.toString());
            }
        });
    }


}
