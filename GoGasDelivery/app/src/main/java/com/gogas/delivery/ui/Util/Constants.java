package com.gogas.delivery.ui.Util;
import android.content.IntentFilter;

public class Constants {

    /*====== for API BASE URLS=====*/

    public static final String API_BASE_URL = "http://omthreeshakti.com/admin_web_app/gogas/api/";
    //public static final String API_VERSION = "v1.0";
    public static final String API_CUSTOMER_BASE_URL = API_BASE_URL+"Vehicle";
    public static final String API_CUSTOMER_BASE_URL_NEW = "https://omthreeshakti.com/admin_web_app/gogas/api/Vehicle/vehicle_sign_in/";

    public static final int HTTP_PORT = 80;
    public static final int HTTPS_PORT = 443;
    public static final int CODE_SUCCESS = 100;
    public static final int HTTP_CODE_SUCCESS = 200;
    public static final int RESPONSE_LIMIT = 15;

    public static final String STATUS_ORDERED="Ordered";
    public static final String STATUS_CANCELLED="Cancelled";
    public static final String STATUS_INTRANSIT="InTransit";
    public static final String STATUS_DELIVERED="Delivered";
    public static final String STATUS_APPROVED="Approved";

    public static final int REQUEST_CODE = 1001;
    public static final String RESULT = "result";

    /*====== END OF API BASE URLS for Delivery App =====*/


    public static final  String KEY_DELIVERY="delivery_key";
    public static final String NAVIGATE_URL = "https://www.google.co.in/maps/dir/Your+Location/";

    //public static final String API_BASE_URL = "https://www.omthreeshakti.com/go_gas/api/";

    public static final String API_VERSION = "v1.0";
    public static final String API_DELIVERYBOY_BASE_URL = API_BASE_URL+API_VERSION+"/deliveryboys";

    //public static final int CODE_SUCCESS = 100;
    //Email Validation pattern
    public static final String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

    public static final int RESPONSE_FIRST_PAGE =0 ;
    //public static final int RESPONSE_LIMIT = 20;

    public static final String INTENT_FILTER = "android.intent.action.order.status";
    public static final String INTENT_MESSAGE = "intent_msg";

    public static final String GOOGLE_MAP_KEY="AIzaSyApikLyj7eaDuCrKcmnkzLJREnZbF01sUs";


}
