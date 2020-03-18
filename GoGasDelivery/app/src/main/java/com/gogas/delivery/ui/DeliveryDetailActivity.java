package com.gogas.delivery.ui;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.gogas.delivery.BuildConfig;
import com.gogas.delivery.R;
import com.gogas.delivery.ui.Util.Constants;
import com.gogas.delivery.ui.service.SharedPref;
import com.gogas.delivery.ui.model.BaseResponse;
import com.gogas.delivery.ui.model.DeliveryBoyDetails;
import com.gogas.delivery.ui.model.Orders;
import com.gogas.delivery.ui.service.DataService;
import com.gogas.delivery.ui.service.RetrofitClientInstance;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeliveryDetailActivity extends AppCompatActivity {

    Orders orderModel;
    TextView name,id,address,paymentType,payableAmount,mobile;

    RelativeLayout progressBar;

    private DeliveryBoyDetails deliveryBoyDetails;
    private InputMethodManager imm = null;
    private LinearLayout layoutDelivery;

    private ImageView mapImage;

    private int locationRequestCode = 1000;
    private double latitude = 0.0, longitude = 0.0;

    private   FusedLocationProviderClient mFusedLocationClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_detail);

        progressBar = findViewById(R.id.progress_bar);

        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mapImage = findViewById(R.id.map_image);

        try {
            orderModel = (Orders) getIntent().getSerializableExtra(Constants.KEY_DELIVERY);
            name = findViewById(R.id.customerName);
            name.setText(orderModel.getCustomer().getName());

            id = findViewById(R.id.customerID);
            id.setText(orderModel.getCustomer_id());


            address = findViewById(R.id.address);
            address.setText(orderModel.getCustomer().getStreet());

            paymentType = findViewById(R.id.payment_type);
            paymentType.setText(orderModel.getPayment_mode());

            payableAmount = findViewById(R.id.payable_amount);
            payableAmount.setText(orderModel.getTotal_price());

            mobile = findViewById(R.id.contactNumber);
            mobile.setText(orderModel.getCustomer().getMobile_number());

            layoutDelivery = findViewById(R.id.layout_delivery);

            if (orderModel.getOrder_status().equals("Delivered")) {
                layoutDelivery.setVisibility(View.GONE);
            }


        } catch (Exception e) {
        }

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //retrieve info from Shared preference
        Gson gson = new Gson();
        String json = SharedPref.read(SharedPref.DELIVER_BOY_DETAIL, "");
        if (!json.isEmpty()) {
            deliveryBoyDetails = gson.fromJson(json, DeliveryBoyDetails.class);
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    locationRequestCode);

        } else {
            getLocationAndUpdateMap();
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1000) {// If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocationAndUpdateMap();
            }
        }
    }

    private void getLocationAndUpdateMap() {

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(DeliveryDetailActivity.this);
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    // Got last known location. In some rare situations, this can be null.
                    if (location != null) {
                        Glide.with(this).load("https://maps.googleapis.com/maps/api/staticmap?zoom=13&size=600x300&maptype=roadmap" +
                                "&markers=color:blue%7Clabel:S%7C"+location.getLatitude()+","+location.getLongitude()+"&markers=color:red%7Clabel:C%7C"+orderModel.getCustomer().getLatitude()+","+orderModel.getCustomer().getLongitude()+
                                "&key="+ Constants.GOOGLE_MAP_KEY).into(mapImage);
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void navigateCall(View view) {
        if(orderModel !=null) {
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                    Uri.parse(Constants.NAVIGATE_URL + orderModel.getCustomer().getLatitude() + "," + orderModel.getCustomer().getLongitude()));
            startActivity(intent);
        }
    }

    public void cancelClk(View view) {
        finish();
    }

    public void OTPPopupCall(View view) {
        // Create custom dialog object
        final Dialog dialog = new Dialog(DeliveryDetailActivity.this);
        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog_otp);
        // Set dialog title
        dialog.setTitle("OTP Alert!");
        EditText etOTP = dialog.findViewById(R.id.otp);


        RelativeLayout popup_progressBar = dialog.findViewById(R.id.progress_bar);

        etOTP.post(() -> {
            etOTP.requestFocus();
            imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(etOTP, InputMethodManager.SHOW_IMPLICIT);
        });


        dialog.show();

        Button backToLoginBtn = (Button) dialog.findViewById(R.id.backToLoginBtn);
        backToLoginBtn.setOnClickListener(v -> {
            imm.toggleSoftInputFromWindow(view.getWindowToken(), 0, 0);
            dialog.dismiss();
        });

        Button submit = (Button) dialog.findViewById(R.id.forgot_submit);
        submit.setOnClickListener(v -> {
            String otpVal = etOTP.getText().toString();
            if (otpVal.length() > 1) {

                    imm.toggleSoftInputFromWindow(view.getWindowToken(), 0, 0);
                    popup_progressBar.setVisibility(View.VISIBLE);
                updateOrderStatusCall(otpVal, dialog);

            } else {
                etOTP.setError("enter OTP");
            }

        });
    }

    public void deliverClk(View view) {
        OTPPopupCall(view);
    }


    private void updateOrderStatusCall(String otpVal, Dialog dialog){
        progressBar.setVisibility(View.VISIBLE);

        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("e_order_status", "Delivered");
        requestBody.put("e_payment_status", "Completed");
        requestBody.put("e_payment_mode", "COD");
        requestBody.put("v_transaction_number", "ABC123");
        requestBody.put("v_otp", otpVal);


        DataService service = RetrofitClientInstance.getRetrofitInstance(DeliveryDetailActivity.this).create(DataService.class);

        Call<BaseResponse> call = service.updateDelivery(String.valueOf(Math.round(deliveryBoyDetails.getId())),orderModel.getId(), deliveryBoyDetails.getAuthorization(),requestBody);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                progressBar.setVisibility(View.GONE);
                dialog.dismiss();
                if (response.isSuccessful()) {
                    BaseResponse res = response.body();
                    if (res != null && res.getCode() == Constants.CODE_SUCCESS) {
                        Toast.makeText(DeliveryDetailActivity.this, "Delivery status updated successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DeliveryDetailActivity.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(DeliveryDetailActivity.this, res.getMsg(), Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(DeliveryDetailActivity.this, response.message(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                dialog.dismiss();
                Toast.makeText(DeliveryDetailActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
