package com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.childsOfFragmentCatalog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.obimilitaryfragments.MainModule.fragments.fragmentCatalog.POJOFragmentCatalog.categories.Category;
import com.obimilitaryfragments.R;

public class ChildNameOfDirectoryFragmentCatalog extends Fragment {
    Context context;
    Category category;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.child_name_of_directory_fragment_catalog, null);
        TextView textView = view.findViewById(R.id.textViewInChildNameOfDirectoryFragmentCategory);
        textView.setText(category.getName());

        return view;
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

    public void getDataFromParent(Category category) {
        this.category = category;
    }
}
