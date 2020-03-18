package com.gogas.delivery.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.gogas.delivery.R;
import com.gogas.delivery.ui.MainActivity;
import com.gogas.delivery.ui.Util.Constants;
import com.gogas.delivery.ui.Util.CustomToast;
import com.gogas.delivery.ui.adapter.DeliveryRecyclerAdapter;
import com.gogas.delivery.ui.listener.PaginationScrollListener;
import com.gogas.delivery.ui.model.DeliveryBoyDetails;
import com.gogas.delivery.ui.model.DeliveryListResponse;
import com.gogas.delivery.ui.model.Orders;
import com.gogas.delivery.ui.service.DataService;
import com.gogas.delivery.ui.service.RetrofitClientInstance;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A placeholder fragment containing a simple view.
 */
public class DeliveryFragment extends Fragment {

    private static final String TAG = "DeliveryFragment";
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    @BindView(R.id.total_delivery)
    TextView totalDelivery;


    private DeliveryRecyclerAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private int currentPage = Constants.RESPONSE_FIRST_PAGE;
    private boolean isLastPage = false;
    private int totalPage = Constants.RESPONSE_FIRST_PAGE;
    private boolean isLoading = false;


    private View root;

    private DeliveryBoyDetails deliveryBoyDetails;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_delivery, container, false);
        ButterKnife.bind(this, root);

        deliveryBoyDetails = ((MainActivity) getActivity()).getDeliveryBoyDetails();

        swipeRefresh.setRefreshing(false);
        swipeRefresh.setEnabled(false);

        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new DeliveryRecyclerAdapter(getActivity(), new ArrayList<>());
        mRecyclerView.setAdapter(mAdapter);
        preparedListItem(false);
        /**
         * add scroll listener while user reach in bottom load more will call
         */
        mRecyclerView.addOnScrollListener(new PaginationScrollListener(mLayoutManager) {
            @Override
            protected void loadMoreItems() {
                isLoading = true;
                currentPage++;
                preparedListItem(true);

            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });

        ((MainActivity) getActivity()).setiRefreshOrderStatus(() -> {
            mAdapter.clear();
            currentPage=Constants.RESPONSE_FIRST_PAGE;
            preparedListItem(false);
        });

        return root;
    }

    private void preparedListItem(boolean isLoadMore) {
        totalDelivery.setText("0");
        if (!isLoadMore) {
            ((MainActivity) getActivity()).showProgress();
        }

        DataService service = RetrofitClientInstance.getRetrofitInstance(getActivity()).create(DataService.class);

        Call<DeliveryListResponse> call = service.getAllDeliveries(String.valueOf(Math.round(deliveryBoyDetails.getId())), deliveryBoyDetails.getAuthorization(), true, Constants.RESPONSE_LIMIT, 0, "d_order_date_time", "DESC", "COD,Online", "Ordered,InTransit");
        call.enqueue(new Callback<DeliveryListResponse>() {
            @Override
            public void onResponse(Call<DeliveryListResponse> call, Response<DeliveryListResponse> response) {
                ((MainActivity) getActivity()).hideProgress();
                if (response.isSuccessful()) {
                    DeliveryListResponse deliveryResponse = response.body();
                    if (deliveryResponse != null && deliveryResponse.getAssignedOrders()!=null && deliveryResponse.getCode() == Constants.CODE_SUCCESS) {
                        totalPage = deliveryResponse.getAssignedOrders().size() < Constants.RESPONSE_LIMIT ? totalPage : totalPage++;

                        totalDelivery.setText(String.valueOf(deliveryResponse.getData().getTotal_orders()));

                        if (currentPage != Constants.RESPONSE_FIRST_PAGE) mAdapter.removeLoading();
                        mAdapter.addAll(deliveryResponse.getAssignedOrders());
                        swipeRefresh.setRefreshing(false);
                        if (currentPage < totalPage) mAdapter.addLoading();
                        else isLastPage = true;
                        isLoading = false;
                    } else if (response.code() == 401 || response.code() == 102) {
                        CustomToast.Show(getActivity(), root, "Unauthorized Request, Please login again.!");
                    }
                } else if (response.code() == 401 || response.code() == 102) {
                    CustomToast.Show(getActivity(), root, "Unauthorized Request, Please login again.!");
                }else{
                    CustomToast.Show(getActivity(), root, "Error in Response");
                }


            }

            @Override
            public void onFailure(Call<DeliveryListResponse> call, Throwable t) {
                ((MainActivity) getActivity()).hideProgress();
                CustomToast.Show(getActivity(), root, "Something went wrong...Please try later!");
            }
        });

    }

}