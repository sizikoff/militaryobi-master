package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.CatalogFragment;
import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories.Category;
import com.obimilitaryfragments.R;
import com.obimilitaryfragments.commonClassesAndUtils.ServerAddress;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapterCatalogFrag extends RecyclerView.Adapter<RecyclerAdapterCatalogFrag.ViewHolder>{

    private static final String TAG = "RecyAdapCatFrag";
    private ArrayList<Category> productArray;
    private LayoutInflater inflater;
    private Context context;
    Category category, myCategory;
    CatalogFragment catalogFragment;

    public RecyclerAdapterCatalogFrag(Context context, ArrayList<Category> productArray, CatalogFragment catalogFragment) {
        this.context = context;
        this.productArray = productArray;

        if (context != null) {
            this.inflater = LayoutInflater.from(context);
        }
        this.catalogFragment = catalogFragment;
    }

    @NonNull
    @Override
    public RecyclerAdapterCatalogFrag.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_recycler_for_catalog, viewGroup, false);
        return new ViewHolder(view, context, category) ;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
        category = productArray.get(position);
        viewHolder.textView.setText(category.getName());

        String src = productArray.get(position).getImage();
        Picasso.with(inflater.getContext()).load(ServerAddress.getbaseURL() + src).resize(50, 50).into(viewHolder.imageView);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myCategory = productArray.get(viewHolder.getAdapterPosition());
                    catalogFragment.sendCatalogToFragment(viewHolder.getAdapterPosition(), myCategory, viewHolder.textView, viewHolder.imageView);
                    Log.i(TAG, "Mycategory.getName(): " + myCategory.getName());
                }
        });
    }

    @Override
    public int getItemCount() {
        return productArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        final Context context;
        final TextView textView;
        final ImageView imageView;
        CardView cardView;
        Category category;
        ViewHolder(View view, final Context context, Category category){
            super(view);
            this.category = category;
            this.context = context;

            textView = view.findViewById(R.id.categoryNameInCatalogCard);
            imageView = view.findViewById(R.id.imageInCatalogCard);
            cardView = view.findViewById(R.id.cardViewFragmentCatalog);
        }
    }
}