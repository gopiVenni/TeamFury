package com.gogas.delivery.ui.model;

import com.google.gson.annotations.SerializedName;

public class DeliveryBoyDetails {

    @SerializedName("id")
    private float id;

    @SerializedName("i_distributor_id")
    private String distributor_id;

    @SerializedName("i_dealer_id")
    private String dealer_id;

    @SerializedName("i_branch_id")
    private String branch_id;

    @SerializedName("v_delivery_boy_id")
    private String delivery_boy_id;

    @SerializedName("v_name")
    private String name;

    @SerializedName("v_email_id")
    private String email_id;

    @SerializedName("v_password")
    private String password;

    @SerializedName("e_gender")
    private String gender;

    @SerializedName("d_date_of_birth")
    private String date_of_birth;

    @SerializedName("v_mobile_number")
    private String mobile_number;

    @SerializedName("v_house_no")
    private String house_no;

    @SerializedName("v_street")
    private String street;

    @SerializedName("v_landmark")
    private String landmark;

    @SerializedName("i_area_id")
    private String area_id;

    @SerializedName("i_city_id")
    private String city_id;

    @SerializedName("i_state_id")
    private String state_id;

    @SerializedName("v_pincode")
    private String pincode;

    @SerializedName("v_licence_number")
    private String licence_number;

    @SerializedName("v_address_document")
    private String address_document = null;

    @SerializedName("v_latitude")
    private String latitude;

    @SerializedName("v_longitude")
    private String longitude;

    @SerializedName("d_date_of_joining")
    private String date_of_joining = null;

    @SerializedName("e_device_type")
    private String device_type;

    @SerializedName("v_device_token")
    private String device_token;

    @SerializedName("api_token")
    private String api_token;

    @SerializedName("v_app_version")
    private String app_version;

    @SerializedName("e_login_status")
    private String login_status;

    @SerializedName("email_verification_code")
    private String v_email_verification_code;

    @SerializedName("e_is_email_verify")
    private String is_email_verify;

    @SerializedName("forgot_password_code")
    private String v_forgot_password_code;

    @SerializedName("e_register_type")
    private String register_type;

    @SerializedName("e_status")
    private String status;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("d_last_login_date")
    private String last_login_date;

    @SerializedName("d_fcode_expiry_date")
    private String fcode_expiry_date;

    @SerializedName("d_vcode_expiry_date")
    private String vcode_expiry_date;

    @SerializedName("deleted_at")
    private String deleted_at = null;

    public float getId() {
       return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getDistributor_id() {
        return distributor_id;
    }

    public void setDistributor_id(String distributor_id) {
        this.distributor_id = distributor_id;
    }

    public String getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(String dealer_id) {
        this.dealer_id = dealer_id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getDelivery_boy_id() {
        return delivery_boy_id;
    }

    public void setDelivery_boy_id(String delivery_boy_id) {
        this.delivery_boy_id = delivery_boy_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getHouse_no() {
        return house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getLicence_number() {
        return licence_number;
    }

    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
    }

    public String getAddress_document() {
        return address_document;
    }

    public void setAddress_document(String address_document) {
        this.address_document = address_document;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDate_of_joining() {
        return date_of_joining;
    }

    public void setDate_of_joining(String date_of_joining) {
        this.date_of_joining = date_of_joining;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public String getApp_version() {
        return app_version;
    }

    public void setApp_version(String app_version) {
        this.app_version = app_version;
    }

    public String getLogin_status() {
        return login_status;
    }

    public void setLogin_status(String login_status) {
        this.login_status = login_status;
    }

    public String getV_email_verification_code() {
        return v_email_verification_code;
    }

    public void setV_email_verification_code(String v_email_verification_code) {
        this.v_email_verification_code = v_email_verification_code;
    }

    public String getIs_email_verify() {
        return is_email_verify;
    }

    public void setIs_email_verify(String is_email_verify) {
        this.is_email_verify = is_email_verify;
    }

    public String getV_forgot_password_code() {
        return v_forgot_password_code;
    }

    public void setV_forgot_password_code(String v_forgot_password_code) {
        this.v_forgot_password_code = v_forgot_password_code;
    }

    public String getRegister_type() {
        return register_type;
    }

    public void setRegister_type(String register_type) {
        this.register_type = register_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getLast_login_date() {
        return last_login_date;
    }

    public void setLast_login_date(String last_login_date) {
        this.last_login_date = last_login_date;
    }

    public String getFcode_expiry_date() {
        return fcode_expiry_date;
    }

    public void setFcode_expiry_date(String fcode_expiry_date) {
        this.fcode_expiry_date = fcode_expiry_date;
    }

    public String getVcode_expiry_date() {
        return vcode_expiry_date;
    }

    public void setVcode_expiry_date(String vcode_expiry_date) {
        this.vcode_expiry_date = vcode_expiry_date;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
    }


    public String getAuthorization() {
        return "Bearer " + getApi_token();
    }
}
