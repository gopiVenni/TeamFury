package com.gogas.delivery.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gogas.delivery.R;
import com.gogas.delivery.ui.DeliveryDetailActivity;
import com.gogas.delivery.ui.Util.Constants;
import com.gogas.delivery.ui.model.Orders;
import com.gogas.delivery.ui.viewholder.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DeliveryRecyclerAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final int VIEW_TYPE_LOADING = 0;
    private static final int VIEW_TYPE_NORMAL = 1;
    private boolean isLoaderVisible = false;

    private List<Orders> mPostItems;

    private Context context;

    public DeliveryRecyclerAdapter(Context context, List<Orders> postItems) {
        this.mPostItems = postItems;
        this.context = context;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delivery, parent, false));
            case VIEW_TYPE_LOADING:
                return new FooterHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false));
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoaderVisible) {
            return position == mPostItems.size() - 1 ? VIEW_TYPE_LOADING : VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_NORMAL;
        }
    }

    @Override
    public int getItemCount() {
        return mPostItems == null ? 0 : mPostItems.size();
    }

    public void add(Orders response) {
        mPostItems.add(response);
        notifyItemInserted(mPostItems.size() - 1);
    }

    public void addAll(List<Orders> postItems) {
        for (Orders response : postItems) {
            add(response);
        }
    }


    private void remove(Orders postItems) {
        int position = mPostItems.indexOf(postItems);
        if (position > -1) {
            mPostItems.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void addLoading() {
        isLoaderVisible = true;
        add(new Orders());
    }

    public void removeLoading() {
        isLoaderVisible = false;
        int position = mPostItems.size() - 1;
        Orders item = getItem(position);
        if (item != null) {
            mPostItems.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    Orders getItem(int position) {
        return mPostItems.get(position);
    }


    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.customerID)
        TextView customerID;

        @BindView(R.id.customerName)
        TextView customerName;

        @BindView(R.id.contactNumber)
        TextView contactNumber;

        @BindView(R.id.cylinderSize)
        TextView cylinderSize;

        @BindView(R.id.address)
        TextView address;

        @BindView(R.id.navigate)
        LinearLayout navigate;

        @BindView(R.id.detail)
        LinearLayout detail;

        @BindView(R.id.day)
        TextView day;

        @BindView(R.id.month)
        TextView month;

        @BindView(R.id.year)
        TextView year;


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {

        }

        public void onBind(int position) {
            super.onBind(position);
            Orders o = mPostItems.get(position);
            try {

                customerID.setText(o.getCustomer_id());
                customerName.setText(o.getCustomer().getName());
                cylinderSize.setText(o.getCylinderType().getName());
                contactNumber.setText(o.getCustomer().getMobile_number());
                address.setText(o.getCustomer().getStreet());

                String dateVal = o.getCreated_at().split(" ")[0];
                day.setText(dateVal.split("-")[0]);
                month.setText(dateVal.split("-")[1]);
                year.setText(dateVal.split("-")[2]);

                navigate.setOnClickListener(view -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse(Constants.NAVIGATE_URL + o.getCustomer().getLatitude() + "," + o.getCustomer().getLongitude()));
                    context.startActivity(intent);
                });

                detail.setOnClickListener(view -> {
                    Intent intent = new Intent(context, DeliveryDetailActivity.class);
                    intent.putExtra(Constants.KEY_DELIVERY, o);
                    context.startActivity(intent);
                });
            }catch (Exception e){}

        }
    }

    public class FooterHolder extends BaseViewHolder {

        @BindView(R.id.progress_bar)
        RelativeLayout progressBar;


        FooterHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void clear() {

        }

    }

}
