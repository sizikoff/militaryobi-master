package com.obimilitaryfragments.commonClassesAndUtils.retrofit;

import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOAkzii.ItemAkzii;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories.CategoriesOfStore;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.products.ProductsOfStore;
import com.obimilitaryfragments.MainModule.fragments.fragmentSearch.POJOActFourFragOne.FindingProducts;
import com.obimilitaryfragments.NullModule.fragments.fragmentChooseStoreHandly.POJO.CitiesWithStores;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitNetwork {

    @GET("graphql?query=query { cities(has:stores) { id name lat lng mapzoom code stores { id obi_store_id obi_store_id_prepared feed_version name description city_id delivery order_and_take address email work_time rest_time phone auto_map lat lng }} }")
    Call<CitiesWithStores> getCitiesWithStores();

    @GET ("graphql")
    Call<CategoriesOfStore> getCategoriesOfStore(@Query("query") String query);

    @GET ("graphql")
    Call<ProductsOfStore> getArrayOfProducts(@Query("query") String query, @Query("variables") String variables);

    @GET ("graphql")
    Call<FindingProducts> getFindingProducts(@Query("query") String query, @Query("variables") String variables);

    @GET("api/getOffersList")
    Call<List<ItemAkzii>> getAkcii(@Query("store_id") String store_id);

}