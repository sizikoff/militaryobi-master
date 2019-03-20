package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOAkzii.ItemAkzii;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories.CategoriesOfStore;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories.Category;

import java.util.ArrayList;

class Presenter implements ContractFragmentCatalog.Presenter, ContractFragmentCatalog.Model.OnFinishedListenerCatalog,
        ContractFragmentCatalog.Model.OnFinishedListenerAkcii {

    private static final String TAG = "PresFragmentCatalog";
    private ContractFragmentCatalog.MainView mainView;
    private ContractFragmentCatalog.Model modelFragmentCatalog;
    Context context;

    CategoriesOfStore categoriesOfStore;
    ArrayList<Category> categoriesAndUnderCategories = new ArrayList<>();

    ArrayList<Category> parentsNullList;

    String storeName;
    int obiStoreId;

    public Presenter(ContractFragmentCatalog.MainView mainView, ContractFragmentCatalog.Model model, Context context) {
        this.mainView = mainView;
        this.modelFragmentCatalog = model;
        this.context = context;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    //запрашиваем у модели список категорий передавая ей в динамический запрос наш крутой название магаза и его айдишник
    @Override
    public void requestCatalogFromServer(String storeName, int obiStoreId) {
        this.storeName = storeName;
        this.obiStoreId = obiStoreId;

        modelFragmentCatalog.getArrayListCatalog(this, storeName, obiStoreId);
    }

    //получаем список категорий и подкатегорий и показываем корневые элементы в активити
    @Override
    public void onFinishedCatalog(CategoriesOfStore categoriesOfStore) {
        this.categoriesOfStore = categoriesOfStore;
        categoriesAndUnderCategories = categoriesOfStore.getDataThirdModule().getCategories();

        getTheParentListAndSetItToActivity();
        Log.i(TAG, "categoriesOfStoreSize: " + categoriesOfStore.getDataThirdModule().getCategories().size());
    }

    //как только происходит клик на ресайклер, формируем списочек детей и отправляем его на показ в активити
    @Override
    public void onItemRecyclerViewCatalogClicked(int pos, Category category, TextView textView, ImageView imageView) {
        int idOfProduct = category.getId();

        ArrayList<Category> myNextElementProducts = new ArrayList<>();
        for (int i = 0; i<categoriesAndUnderCategories.size(); i++) {
            if (categoriesAndUnderCategories.get(i).getParentId() == idOfProduct) {
                myNextElementProducts.add(categoriesAndUnderCategories.get(i));
            }
        }
        mainView.setRecyclerViewCatalog(myNextElementProducts);
        Log.i(TAG, "myNextElementProducts: " + myNextElementProducts.size());
    }

    //метод на случай каких либо ошибок
    @Override
    public void onFailureCatalog(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailureCatalog(t);
        }
    }

    //служебный метод во избежание задваивания кода
    private void getTheParentListAndSetItToActivity() {
        parentsNullList = new ArrayList<>();
        for (int i = 0; i<categoriesAndUnderCategories.size(); i++) {
            if (categoriesAndUnderCategories.get(i).getParentId() == 0) {
                parentsNullList.add(categoriesAndUnderCategories.get(i));
            }
        }
        mainView.setRecyclerViewCatalog(parentsNullList);
    }

    //запрашиваем спииок акций
    @Override
    public void getAkziiPresenter(String nameStore, int obiStoreId) {
        modelFragmentCatalog.getAkcii(this, nameStore, obiStoreId);
    }

    @Override
    public void onFinishedAkcii(ArrayList<ItemAkzii> itemAkziis) {
        mainView.setRecyclerWithAkzii(itemAkziis);
    }

    @Override
    public void onFailureAkcii(Throwable t) {

    }
}
