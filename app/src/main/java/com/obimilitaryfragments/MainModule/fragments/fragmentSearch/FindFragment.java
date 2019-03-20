package com.obimilitaryfragments.MainModule.fragments.fragmentSearch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.obimilitaryfragments.MainModule.fragments.fragmentSearch.POJOActFourFragOne.Product;
import com.obimilitaryfragments.MainModule.fragments.fragmentSearch.adapters.RecyclerViewAdapterForFindingProducts;
import com.obimilitaryfragments.R;

import java.util.ArrayList;

public class FindFragment extends Fragment implements Contract.MainView {

    Contract.Presenter presenter;
    RecyclerView recyclerView;
    Button buttonFind;
    EditText editText;
    Context context;

    private static final String TAG = "FindFragActFour";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_find, null);

        recyclerView = view.findViewById(R.id.recyclerViewInFragmentOneActivityFourth);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);

        presenter = new Presenter(this, new Model(), context);

        buttonFind = view.findViewById(R.id.buttonFindProductInFragmentFindFourthAct);
        editText = view.findViewById(R.id.editTextInToolBarInForthMA);
        buttonFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "buttonFind pressed");

                String findingProduct = editText.getText().toString();
                Log.i(TAG, "String findingProduct: " + findingProduct);

                if (findingProduct.length()<=2 || findingProduct.length()>=30) {
                    Toast.makeText(context, "запрос должен быть от 3 до 30 символов", Toast.LENGTH_SHORT).show();
                } else {
                    presenter.requestDataFromServer(findingProduct);
                    hideTheKeyboard(context, v);
                }
            }
        });

        showTheKeyboard();
        editText.requestFocus();
        return view;
    }

    @Override
    public void setDataToRecycler(ArrayList<Product> products) {
        RecyclerViewAdapterForFindingProducts adapter = new RecyclerViewAdapterForFindingProducts(context, products);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResponseFailure(Throwable throwable) {

    }

    public void nothingToShow() {
        Toast.makeText(context, "ни одного совпадения не найдено", Toast.LENGTH_SHORT).show();
    }

    //метод прячущий клаву
    private void hideTheKeyboard(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

    //метод показывающий клаву
    private void showTheKeyboard() {
        ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(
                InputMethodManager.SHOW_FORCED,
                InputMethodManager.HIDE_IMPLICIT_ONLY
        );
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

}
