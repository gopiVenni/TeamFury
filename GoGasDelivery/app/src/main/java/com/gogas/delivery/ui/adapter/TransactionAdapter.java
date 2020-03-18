package com.gogas.delivery.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.gogas.delivery.R;
import com.gogas.delivery.ui.model.TransactionModel;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.MyViewHolder> {
    private List<TransactionModel> transactionList;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView totalCashCollected;
        public TextView totalDeliveries;
        public TextView settlementStatus;
        public TextView day;
        public TextView month;
        public TextView year;

        public MyViewHolder(LinearLayout v) {
            super(v);
            totalCashCollected = v.findViewById(R.id.totalCashCollected);
            totalDeliveries = v.findViewById(R.id.totalDeliveries);
            settlementStatus = v.findViewById(R.id.settlementStatus);
            day = v.findViewById(R.id.day);
            month = v.findViewById(R.id.month);
            year = v.findViewById(R.id.year);
        }
    }

    public TransactionAdapter(Context context, List<TransactionModel> tranactionList) {
        this.context = context;
        this.transactionList = tranactionList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TransactionAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tranaction, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TransactionModel dm = transactionList.get(position);
        holder.totalCashCollected.setText(dm.getTotalCashCollected());
        holder.totalDeliveries.setText(dm.getTotalDeliveries());
        holder.settlementStatus.setText(dm.getSettlementStatus());

        holder.day.setText(dm.getDate().split(":")[0]);
        holder.month.setText(dm.getDate().split(":")[1]);
        holder.year.setText(dm.getDate().split(":")[2]);

    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }
}