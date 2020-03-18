package com.gogas.delivery.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.gogas.delivery.BuildConfig;
import com.gogas.delivery.R;
import com.gogas.delivery.ui.Util.Constants;
import com.gogas.delivery.ui.Util.CustomToast;
import com.gogas.delivery.ui.listener.IRefreshOrderStatus;
import com.gogas.delivery.ui.model.BaseResponse;
import com.gogas.delivery.ui.service.DataService;
import com.gogas.delivery.ui.service.RetrofitClientInstance;
import com.gogas.delivery.ui.service.SharedPref;
import com.gogas.delivery.ui.adapter.SectionsPagerAdapter;
import com.gogas.delivery.ui.model.DeliveryBoyDetails;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    private TextView navName, navEmail;
    private IRefreshOrderStatus iRefreshOrderStatus;
    private IRefreshOrderStatus iRefreshHistoryStatus;

    @BindView(R.id.root)
    CoordinatorLayout root;

    @BindView(R.id.progress_bar)
    RelativeLayout progressBar;

    @BindView(R.id.homeTab)
    TextView m_homeTab;

    @BindView(R.id.orderstatusTab)
    TextView m_orderstatusTab;

    @BindView(R.id.historyTab)
    TextView m_historyTab;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private DeliveryBoyDetails deliveryBoyDetails;

    private View rootView;

    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rootView = getWindow().getDecorView().getRootView();

        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        navName = navigationView.getHeaderView(0).findViewById(R.id.nav_name);
        navEmail = navigationView.getHeaderView(0).findViewById(R.id.nav_email);

        //version name
        ((TextView)navigationView.findViewById(R.id.version)).setText("V("+ BuildConfig.VERSION_NAME+")");

        navigationView.findViewById(R.id.footer_signout).setOnClickListener(v -> {
            callSignOut();
        });


        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.addOnPageChangeListener(this);

        //retrieve info from Shared preference
        Gson gson = new Gson();
        String json = SharedPref.read(SharedPref.DELIVER_BOY_DETAIL, "");
        if (!json.isEmpty()) {
            DeliveryBoyDetails details = gson.fromJson(json, DeliveryBoyDetails.class);
            navName.setText(details.getName());
            navEmail.setText(details.getEmail_id());
            this.deliveryBoyDetails = details;
           // registerFCM();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {

            CustomToast.Show(MainActivity.this, root, "Refreshing Data...");

            if (iRefreshOrderStatus != null) {
                iRefreshOrderStatus.doRefresh();
            }

            if (iRefreshHistoryStatus != null) {
                iRefreshHistoryStatus.doRefresh();
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void registerFCM() {

        if (SharedPref.getFcm_token().isEmpty()) {
            FirebaseInstanceId.getInstance().getInstanceId()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            updateToken(Objects.requireNonNull(task.getResult()).getToken());
                        }
                    });
        }
    }

    private void updateToken(String token) {
        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("v_device_token", token);


        DataService service = RetrofitClientInstance.getRetrofitInstance(MainActivity.this).create(DataService.class);

        Call<BaseResponse> call = service.updateToken(String.valueOf(Math.round(deliveryBoyDetails.getId())), deliveryBoyDetails.getAuthorization(), requestBody);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                if (response.isSuccessful()) {
                    BaseResponse res = response.body();
                    if (res != null && res.getCode() == Constants.CODE_SUCCESS) {
                        SharedPref.setFcm_token(token);
                    }
                }

            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                Log.e("FCM token", t.getMessage());
            }
        });
    }


    public DeliveryBoyDetails getDeliveryBoyDetails() {
        return deliveryBoyDetails;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_delivery) {
            viewPager.setCurrentItem(0);
        } else if (id == R.id.nav_history) {
            viewPager.setCurrentItem(1);
        } else if (id == R.id.nav_transaction) {
            viewPager.setCurrentItem(2);
        } else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Hey check out my app at: https://play.google.com/store/apps/details?id="+BuildConfig.APPLICATION_ID);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_send) {

            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{"omthreeshakti56@gmail.com"});
            email.putExtra(Intent.EXTRA_SUBJECT, "Delivery App feedback");
            email.putExtra(Intent.EXTRA_TEXT, "");

            email.setType("message/rfc822");

            startActivity(Intent.createChooser(email, "Choose an Email client :"));

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onhomeTabBtnClick(View view) {
        viewPager.setCurrentItem(0);
    }


    public void onorderstatusTabBtnClick(View view) {
        viewPager.setCurrentItem(1);
    }

    public void onhistoryTabBtnClick(View view) {
        viewPager.setCurrentItem(2);
    }

    private void setSeletedFragment(int i) {
        switch (i) {
            case 1:
                m_homeTab.setBackgroundResource(R.drawable.background_tab_selected);
                m_orderstatusTab.setBackgroundResource(R.drawable.background_tab_unselected);
                m_historyTab.setBackgroundResource(R.drawable.background_tab_unselected);

                m_homeTab.setTextColor(Color.parseColor("#ffffff"));
                m_orderstatusTab.setTextColor(Color.parseColor("#d0313d"));
                m_historyTab.setTextColor(Color.parseColor("#d0313d"));
                break;
            case 2:
                m_homeTab.setBackgroundResource(R.drawable.background_tab_unselected);
                m_orderstatusTab.setBackgroundResource(R.drawable.background_tab_selected);
                m_historyTab.setBackgroundResource(R.drawable.background_tab_unselected);

                m_homeTab.setTextColor(Color.parseColor("#d0313d"));
                m_orderstatusTab.setTextColor(Color.parseColor("#ffffff"));
                m_historyTab.setTextColor(Color.parseColor("#d0313d"));
                break;
            case 3:
                m_homeTab.setBackgroundResource(R.drawable.background_tab_unselected);
                m_orderstatusTab.setBackgroundResource(R.drawable.background_tab_unselected);
                m_historyTab.setBackgroundResource(R.drawable.background_tab_selected);

                m_homeTab.setTextColor(Color.parseColor("#d0313d"));
                m_orderstatusTab.setTextColor(Color.parseColor("#d0313d"));
                m_historyTab.setTextColor(Color.parseColor("#ffffff"));
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        setSeletedFragment(position + 1);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }


    public void setiRefreshOrderStatus(IRefreshOrderStatus iRefreshOrderStatus) {
        this.iRefreshOrderStatus = iRefreshOrderStatus;
    }

    public void setiRefreshHistoryStatus(IRefreshOrderStatus iRefreshHistoryStatus) {
        this.iRefreshHistoryStatus = iRefreshHistoryStatus;
    }

    private void callSignOut() {
        SharedPref.clearAll();
        finish();
        Intent a = new Intent(this, LoginActivity.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(a);

    }

    //*****************************BoardCast receiver*****************//
    @Override
    protected void onResume() {
        super.onResume();
        try {

            IntentFilter intentFilter = new IntentFilter(
                    Constants.INTENT_FILTER);

            mReceiver = new BroadcastReceiver() {

                @Override
                public void onReceive(Context context, Intent intent) {
                    //extract our message from intent
                    String msg = intent.getStringExtra(Constants.INTENT_MESSAGE);
                    CustomToast.Show(MainActivity.this, rootView, msg);


                    if (iRefreshOrderStatus != null) {
                        iRefreshOrderStatus.doRefresh();
                    }

                }
            };
            //registering our receiver
            this.registerReceiver(mReceiver, intentFilter);
        } catch (Exception e) {
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            //unregister our receiver
            this.unregisterReceiver(this.mReceiver);
        } catch (Exception e) {
        }
    }
}


