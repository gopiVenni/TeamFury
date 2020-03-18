package com.gogas.delivery.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.gogas.delivery.BuildConfig;
import com.gogas.delivery.R;
import com.gogas.delivery.ui.Util.Constants;
import com.gogas.delivery.ui.Util.CustomToast;
import com.gogas.delivery.ui.model.BaseResponse;
import com.gogas.delivery.ui.model.LoginResponse;
import com.gogas.delivery.ui.service.DataService;
import com.gogas.delivery.ui.service.RetrofitClientInstance;
import com.gogas.delivery.ui.service.SharedPref;
import com.google.gson.Gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.gogas.delivery.ui.Util.Constants.API_CUSTOMER_BASE_URL;
import static com.gogas.delivery.ui.Util.Constants.API_CUSTOMER_BASE_URL_NEW;

import static com.gogas.delivery.ui.fragment.HistoryFragment.setHttpsCert;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.progress_bar)
    RelativeLayout progressBar;

    @BindView(R.id.edt_username)
    EditText edtUserName;

    @BindView(R.id.edt_password)
    EditText edtUserPass;

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        view = getWindow().getDecorView().getRootView();


        // bind the view using butterknife

        ButterKnife.bind(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        if (!SharedPref.read(SharedPref.DELIVER_BOY_DETAIL, "").isEmpty()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }


    @OnClick(R.id.button_login)
    public void onButtonClick(View view) {

        String username = edtUserName.getText().toString();
        String userPass = edtUserPass.getText().toString();

        if (username.trim().equalsIgnoreCase("")) {
            edtUserName.setError("username empty");
            return;
        }

        if (userPass.trim().equalsIgnoreCase("")) {
            edtUserPass.setError("password empty");
            return;
        }

        if (username.length() < 3) {
            edtUserName.setError("username is short");
            return;
        }

        if (userPass.length() < 3) {
            edtUserPass.setError("password is short");
            return;
        }


        progressBar.setVisibility(View.VISIBLE);

        String url = API_CUSTOMER_BASE_URL_NEW;
        //AsyncHttpClient client = new AsyncHttpClient(true,Constants.HTTP_PORT,Constants.HTTPS_PORT);
        AsyncHttpClient client = new AsyncHttpClient();
        setHttpsCert(client);
        RequestParams params = new RequestParams();
        params.put("v_vehicle_id", username);
        params.put("v_password", userPass);

        client.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                progressBar.setVisibility(View.GONE);
                String mJsonString = response.toString();
                try {
                    if (response.get("msg").equals("Success") && statusCode == Constants.HTTP_CODE_SUCCESS) {
                        JsonParser parser = new JsonParser();
                        JsonElement mJson =  parser.parse(mJsonString);
                        Gson gson = new Gson();
                        LoginResponse loginResponse = gson.fromJson(mJson, LoginResponse.class);
                        if (loginResponse != null && loginResponse.getCode() == Constants.CODE_SUCCESS) {
                            String json = gson.toJson(loginResponse.getVehicleDetails());
                            SharedPref.write(SharedPref.DELIVER_BOY_DETAIL, json);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();

                        }else{
                            CustomToast.Show(LoginActivity.this, view, loginResponse.getMsg());
                        }
                    }else{
                        CustomToast.Show(LoginActivity.this, view, "Something went wrong...Please try later!");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);

                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(),"Hai",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);

                progressBar.setVisibility(View.GONE);
                CustomToast.Show(LoginActivity.this, view, "Something went wrong...Please try later!");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                progressBar.setVisibility(View.GONE);
                CustomToast.Show(LoginActivity.this, view, "Something went wrong...Please try later!");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)

                progressBar.setVisibility(View.GONE);
                CustomToast.Show(LoginActivity.this, view, "Something went wrong...Please try later!");
            }
        });


        /*
        progressBar.setVisibility(View.VISIBLE);
        DataService service = RetrofitClientInstance.getRetrofitInstance(LoginActivity.this).create(DataService.class);

        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("v_delivery_boy_id", username);
        requestBody.put("v_password", userPass);
        requestBody.put("v_device_token", "gogas_db_56824766");
        requestBody.put("v_app_version", BuildConfig.VERSION_NAME);

        Call<LoginResponse> call = service.loginUser(requestBody);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    if (loginResponse != null && loginResponse.getCode() == Constants.CODE_SUCCESS) {
                        Gson gson = new Gson();
                        String json = gson.toJson(loginResponse.getDeliveryBoyDetails());
                        SharedPref.write(SharedPref.DELIVER_BOY_DETAIL, json);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        CustomToast.Show(LoginActivity.this, view, loginResponse.getMsg());
                    }
                } else {
                    CustomToast.Show(LoginActivity.this, view, "Something went wrong...Please try later!");
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                CustomToast.Show(LoginActivity.this, view, "Something went wrong...Please try later!");
            }
        });*/


    }//End onlclick Event

    InputMethodManager imm = null;

    @OnClick(R.id.tv_forgot_pass)
    public void forgotPassClick(View view) {
        // Create custom dialog object
        final Dialog dialog = new Dialog(LoginActivity.this);
        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog_forgot_pass);
        // Set dialog title
        dialog.setTitle(getString(R.string.forgot_pass));
        EditText etEmail = dialog.findViewById(R.id.registered_emailid);


        RelativeLayout popup_progressBar = dialog.findViewById(R.id.progress_bar);

        etEmail.post(new Runnable() {
            @Override
            public void run() {
                etEmail.requestFocus();
                imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(etEmail, InputMethodManager.SHOW_IMPLICIT);
            }
        });


        dialog.show();

        Button backToLoginBtn = (Button) dialog.findViewById(R.id.backToLoginBtn);
        backToLoginBtn.setOnClickListener(v -> {
            imm.toggleSoftInputFromWindow(view.getWindowToken(), 0, 0);
            dialog.dismiss();
        });

        Button submit = (Button) dialog.findViewById(R.id.forgot_submit);
        submit.setOnClickListener(v -> {
            String userEmail = etEmail.getText().toString();
            if (userEmail.length() > 3) {


                // Check patter for email id
                Pattern p = Pattern.compile(Constants.regEx);

                Matcher m = p.matcher(userEmail);

                if (!m.find()) {
                    etEmail.setError("email id is invalid");

                } else {
                    imm.toggleSoftInputFromWindow(view.getWindowToken(), 0, 0);
                    popup_progressBar.setVisibility(View.VISIBLE);
                    forgetPasswordServiceCall(userEmail, dialog);

                }

            } else {
                etEmail.setError("enter email Id");
            }

        });
    }

    private void forgetPasswordServiceCall(String email, Dialog dialog) {
        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("v_email_id", email);


        DataService service = RetrofitClientInstance.getRetrofitInstance(LoginActivity.this).create(DataService.class);

        Call<BaseResponse> call = service.forgotPassword(requestBody);
        call.enqueue(new Callback<BaseResponse>() {
            @Override
            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
                progressBar.setVisibility(View.GONE);
                dialog.dismiss();
                if (response.isSuccessful()) {
                    BaseResponse res = response.body();
                    if (res != null && res.getCode() == Constants.CODE_SUCCESS) {
                        Toast.makeText(LoginActivity.this, "To reset your password, please Check your email", Toast.LENGTH_LONG).show();
                    } else {
                        edtUserName.setError(res.getMsg());
                    }
                }

            }

            @Override
            public void onFailure(Call<BaseResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                dialog.dismiss();
                CustomToast.Show(LoginActivity.this, view, "Something went wrong...Please try later!");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
