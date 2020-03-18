package com.gogas.delivery.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gogas.delivery.R;
import com.gogas.delivery.ui.adapter.TransactionAdapter;
import com.gogas.delivery.ui.model.TransactionModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class TransactionFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<TransactionModel> transactionList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_transaction, container, false);
        recyclerView = (RecyclerView) root.findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        if(transactionList.isEmpty()) {
          /*  transactionList.add(new TransactionModel("Rs. 12,000", "21:July:2019", "20", "Pending"));
            transactionList.add(new TransactionModel("Rs. 15,000", "20:July:2019", "20", "Done"));
            transactionList.add(new TransactionModel("Rs. 12,000", "19:July:2019", "20", "Pending"));
            transactionList.add(new TransactionModel("Rs. 10,000", "18:July:2019", "20", "Done"));
            transactionList.add(new TransactionModel("Rs. 9,000", "17:July:2019", "20", "Done"));
    */    }

        mAdapter = new TransactionAdapter(getActivity(), transactionList);
        recyclerView.setAdapter(mAdapter);

        return root;
    }
}