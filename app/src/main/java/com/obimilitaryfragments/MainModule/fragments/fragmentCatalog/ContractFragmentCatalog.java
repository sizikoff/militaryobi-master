package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog;

import android.widget.ImageView;
import android.widget.TextView;

import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOAkzii.ItemAkzii;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories.CategoriesOfStore;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories.Category;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.products.ItemOfProducts;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.products.ProductsOfStore;

import java.util.ArrayList;

public interface ContractFragmentCatalog {

    interface Presenter{
        void onItemRecyclerViewCatalogClicked(int pos, Category category, TextView textView, ImageView imageView);
        void onDestroy();
        void requestCatalogFromServer(String nameStore, int obiStoreId);
        void getAkziiPresenter(String nameStore, int obiStoreId);

    }

    interface MainView {
        void setRecyclerViewCatalog(ArrayList<Category> s);
        void onResponseFailureCatalog(Throwable throwable);
        void sendCatalogToFragment(int pos, Category category, TextView textView, ImageView imageView);
        void setRecyclerWithAkzii(ArrayList<ItemAkzii> itemAkziis);
    }

    interface Model {

        void getArrayListCatalog(OnFinishedListenerCatalog onFinishedListener, String nameStore, int obiStoreId);
        interface OnFinishedListenerCatalog {
            void onFinishedCatalog(CategoriesOfStore categoriesOfStore);
            void onFailureCatalog(Throwable t);
        }

        void getAkcii(OnFinishedListenerAkcii onFinishedListenerAkcii, String nameStore, int obiStoreId);
        interface OnFinishedListenerAkcii {
            void onFinishedAkcii(ArrayList<ItemAkzii> itemAkziis);
            void onFailureAkcii(Throwable t);
        }
    }
}

