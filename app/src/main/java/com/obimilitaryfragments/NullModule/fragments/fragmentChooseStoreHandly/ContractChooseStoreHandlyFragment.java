package com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly;

import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.CitiesWithStores;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ContractChooseStoreHandlyFragment {

    interface Presenter {
        void onFinished(CitiesWithStores citiesWithStores);
        void onDestroy();
        void requestDataFromServer();
    }

    interface MainView {
        void setItemsToListView(ArrayList<String> myCities, HashMap<String, List<Store>> myChildren);
        void onResponseFailure(Throwable throwable);
    }

    interface Model {
        interface OnFinishedListener {
            void onFinished(CitiesWithStores citiesWithStores);
            void onFailure(Throwable t);
        }

        void getArrayList(OnFinishedListener onFinishedListener);
    }
}
