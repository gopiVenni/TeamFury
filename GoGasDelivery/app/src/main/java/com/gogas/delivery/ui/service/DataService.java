package com.gogas.delivery.ui.service;

import com.gogas.delivery.ui.model.BaseResponse;
import com.gogas.delivery.ui.model.DeliveryHistoryResponse;
import com.gogas.delivery.ui.model.DeliveryListResponse;
import com.gogas.delivery.ui.model.LoginResponse;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.gogas.delivery.ui.Util.Constants.API_DELIVERYBOY_BASE_URL;


public interface DataService {
    @GET(API_DELIVERYBOY_BASE_URL+"/{API_DELIVERYBOY_LOGIN_USERID}/orders")
    Call<DeliveryListResponse> getAllDeliveries(@Path("API_DELIVERYBOY_LOGIN_USERID") String userId, @Header("Authorization") String authorization, @Query("is_pagination") boolean is_pagination, @Query("limit") int limit, @Query("page_no") int page_no, @Query("sort_key_name") String sort_key_name, @Query("sort_key_order") String sort_key_order, @Query("payment_mode") String payment_mode, @Query("order_status") String order_status);

    @GET(API_DELIVERYBOY_BASE_URL+"/{API_DELIVERYBOY_LOGIN_USERID}/orders")
    Call<DeliveryHistoryResponse> getDeliveryHistory(@Path("API_DELIVERYBOY_LOGIN_USERID") String userId,@Header("Authorization") String authorization,  @Query("is_pagination") boolean is_pagination,@Query("limit") int limit,@Query("page_no") int page_no,@Query("sort_key_name") String sort_key_name,@Query("sort_key_order") String sort_key_order,@Query("payment_mode") String payment_mode,@Query("order_status") String order_status);

    @PUT(API_DELIVERYBOY_BASE_URL+"/signin")
    Call<LoginResponse> loginUser(@Body HashMap<String, String> user);

    @PUT(API_DELIVERYBOY_BASE_URL+"/forgotpassword")
    Call<BaseResponse> forgotPassword(@Body HashMap<String, String> user);

    @PUT(API_DELIVERYBOY_BASE_URL+"/{API_DELIVERYBOY_LOGIN_USERID}/orders/{ORDER_ID}")
    Call<BaseResponse> updateDelivery(@Path("API_DELIVERYBOY_LOGIN_USERID") String userId,@Path("ORDER_ID") String orderId,@Header("Authorization") String authorization, @Body HashMap<String, String> user);


    @PUT(API_DELIVERYBOY_BASE_URL+"/{API_DELIVERYBOY_LOGIN_USERID}/device-token")
    Call<BaseResponse> updateToken(@Path("API_DELIVERYBOY_LOGIN_USERID") String userId, @Header("Authorization") String authorization,  @Body HashMap<String, String> device);


}
