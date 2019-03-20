package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOAkzii.ItemAkzii;
import com.obimilitaryfragments.R;
import com.obimilitaryfragments.commonClassesAndUtils.ServerAddress;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class RecyclerViewAdapterForAkzii extends RecyclerView.Adapter<RecyclerViewAdapterForAkzii.ViewHolder> {

    private static final String TAG = "РесайклАдаптер";

    //vars
    private ArrayList<ItemAkzii> mImageUrls;
    private Context mContext;
    private LayoutInflater inflater;


    public RecyclerViewAdapterForAkzii(Context context, ArrayList<ItemAkzii> imageUrls) {
        mImageUrls = imageUrls;
        mContext = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_for_akcii, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        String src = ServerAddress.getbaseURL() + (mImageUrls.get(position).getImage());
        Log.i(TAG,src);

        Picasso.with(inflater.getContext()).load(src).into(viewHolder.image);

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageUrls.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_view);
            cardView = itemView.findViewById(R.id.cardViewInItemRecyclerForAkcii);
        }
    }
}
