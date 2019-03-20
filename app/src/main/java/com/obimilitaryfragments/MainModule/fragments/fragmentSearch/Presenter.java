package com.obimilitaryfragments.MainModule.fragments.fragmentSearch;

import android.content.Context;
import android.util.Log;

import com.obimilitaryfragments.MainModule.fragments.fragmentSearch.POJOActFourFragOne.FindingProducts;
import com.obimilitaryfragments.MainModule.fragments.fragmentSearch.POJOActFourFragOne.Product;

import java.util.ArrayList;

public class Presenter implements Contract.Presenter, Contract.GetDataFromModel.OnFinishedListener {

    private Contract.MainView mainView;
    private Contract.GetDataFromModel model;
    Context context;
    private static final String TAG = "PresFragOneActFour";

    public Presenter(Contract.MainView mainView, Contract.GetDataFromModel model, Context context) {
        this.mainView = mainView;
        this.model = model;
        this.context = context;
    }

    @Override
    public void onFinished(FindingProducts findingProducts) {
        if (findingProducts.getData().getSearch() == null) {
            mainView.nothingToShow();
        } else {
            ArrayList<Product> products = (ArrayList<Product>) findingProducts.getData().getSearch().getProducts();
            Log.i(TAG, "products.size(): " + products.size());
            mainView.setDataToRecycler(products);
        }


    }


    @Override
    public void onFailure(Throwable t) {
        if (mainView != null) {
            mainView.onResponseFailure(t);
        }
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void requestDataFromServer(String findingProduct) {
        model.getArrayList(this, findingProduct);
    }
}
