package com.gogas.delivery.ui.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Orders implements Serializable {
    @SerializedName("id")
    private String id;

    @SerializedName("v_order_number")
    private String order_number;

    @SerializedName("i_distributor_id")
    private String distributor_id;

    @SerializedName("i_branch_id")
    private String branch_id;

    @SerializedName("i_dealer_id")
    private String dealer_id;

    @SerializedName("i_delivery_boy_id")
    private String delivery_boy_id;

    @SerializedName("i_customer_id")
    private String customer_id;

    @SerializedName("i_cylinder_type_id")
    private String cylinder_type_id;

    @SerializedName("i_cylinder_quantity")
    private String cylinder_quntity;

    @SerializedName("d_gst")
    private String gst;

    @SerializedName("d_per_cylinder_price")
    private String per_cylinder_price;

    @SerializedName("d_total_price")
    private String total_price;

    @SerializedName("v_otp")
    private String otp;

    @SerializedName("e_is_otp_verify")
    private String is_otp_verify;

    @SerializedName("e_payment_mode")
    private String payment_mode;

    @SerializedName("e_payment_status")
    private String epayment_status;

    @SerializedName("e_order_status")
    private String order_status;

    @SerializedName("t_assign_notes")
    private String assign_notes;

    @SerializedName("d_expected_delivery_date")
    private String expected_delivery_date;

    @SerializedName("d_schedule_delivery_date")
    private String schedule_delivery_date;

    @SerializedName("i_schedule_delivery_time_id")
    private String schedule_delivery_time_id;

    @SerializedName("d_order_date_time")
    private String order_date_time;

    @SerializedName("v_transaction_number")
    private String transaction_number;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("updated_at")
    private String updated_at;

    @SerializedName("branch")
    private Branch branch;

    @SerializedName("dealer")
    private Dealer dealer;

    @SerializedName("customer")
    private Customer customer;

    @SerializedName("cylinder_type")
    private CylinderType cylinderType;

    @SerializedName("schedule_delivery_times")
    private ScheduleDeliveryTiming scheduleDeliveryTiming;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getDistributor_id() {
        return distributor_id;
    }

    public void setDistributor_id(String distributor_id) {
        this.distributor_id = distributor_id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getDealer_id() {
        return dealer_id;
    }

    public void setDealer_id(String dealer_id) {
        this.dealer_id = dealer_id;
    }

    public String getDelivery_boy_id() {
        return delivery_boy_id;
    }

    public void setDelivery_boy_id(String delivery_boy_id) {
        this.delivery_boy_id = delivery_boy_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCylinder_type_id() {
        return cylinder_type_id;
    }

    public void setCylinder_type_id(String cylinder_type_id) {
        this.cylinder_type_id = cylinder_type_id;
    }

    public String getCylinder_quntity() {
        return cylinder_quntity;
    }

    public void setCylinder_quntity(String cylinder_quntity) {
        this.cylinder_quntity = cylinder_quntity;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public String getPer_cylinder_price() {
        return per_cylinder_price;
    }

    public void setPer_cylinder_price(String per_cylinder_price) {
        this.per_cylinder_price = per_cylinder_price;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getIs_otp_verify() {
        return is_otp_verify;
    }

    public void setIs_otp_verify(String is_otp_verify) {
        this.is_otp_verify = is_otp_verify;
    }

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    public String getEpayment_status() {
        return epayment_status;
    }

    public void setEpayment_status(String epayment_status) {
        this.epayment_status = epayment_status;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getAssign_notes() {
        return assign_notes;
    }

    public void setAssign_notes(String assign_notes) {
        this.assign_notes = assign_notes;
    }

    public String getExpected_delivery_date() {
        return expected_delivery_date;
    }

    public void setExpected_delivery_date(String expected_delivery_date) {
        this.expected_delivery_date = expected_delivery_date;
    }

    public String getSchedule_delivery_date() {
        return schedule_delivery_date;
    }

    public void setSchedule_delivery_date(String schedule_delivery_date) {
        this.schedule_delivery_date = schedule_delivery_date;
    }

    public String getSchedule_delivery_time_id() {
        return schedule_delivery_time_id;
    }

    public void setSchedule_delivery_time_id(String schedule_delivery_time_id) {
        this.schedule_delivery_time_id = schedule_delivery_time_id;
    }

    public String getOrder_date_time() {
        return order_date_time;
    }

    public void setOrder_date_time(String order_date_time) {
        this.order_date_time = order_date_time;
    }

    public String getTransaction_number() {
        return transaction_number;
    }

    public void setTransaction_number(String transaction_number) {
        this.transaction_number = transaction_number;
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

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CylinderType getCylinderType() {
        return cylinderType;
    }

    public void setCylinderType(CylinderType cylinderType) {
        this.cylinderType = cylinderType;
    }

    public ScheduleDeliveryTiming getScheduleDeliveryTiming() {
        return scheduleDeliveryTiming;
    }

    public void setScheduleDeliveryTiming(ScheduleDeliveryTiming scheduleDeliveryTiming) {
        this.scheduleDeliveryTiming = scheduleDeliveryTiming;
    }

    class Branch implements Serializable {
        @SerializedName("id")
        private String id;

        @SerializedName("v_branch_code")
        private String branch_code;

        @SerializedName("v_branch_name")
        private String branch_name;

        @SerializedName("t_address")
        private String address;

        @SerializedName("i_city_id")
        private String city_id;

        @SerializedName("i_state_id")
        private String state_id;

        @SerializedName("i_area_id")
        private String area_id;

        @SerializedName("v_branch_head_person_name")
        private String branch_head_person_name;

        @SerializedName("v_branch_head_person_contact_number")
        private String branch_head_person_contact_number;

        @SerializedName("v_branch_head_person_email")
        private String branch_head_person_email;

        @SerializedName("v_branch_contact_number")
        private String branch_contact_number;

        @SerializedName("v_branch_email")
        private String branch_email;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBranch_code() {
            return branch_code;
        }

        public void setBranch_code(String branch_code) {
            this.branch_code = branch_code;
        }

        public String getBranch_name() {
            return branch_name;
        }

        public void setBranch_name(String branch_name) {
            this.branch_name = branch_name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getBranch_head_person_name() {
            return branch_head_person_name;
        }

        public void setBranch_head_person_name(String branch_head_person_name) {
            this.branch_head_person_name = branch_head_person_name;
        }

        public String getBranch_head_person_contact_number() {
            return branch_head_person_contact_number;
        }

        public void setBranch_head_person_contact_number(String branch_head_person_contact_number) {
            this.branch_head_person_contact_number = branch_head_person_contact_number;
        }

        public String getBranch_head_person_email() {
            return branch_head_person_email;
        }

        public void setBranch_head_person_email(String branch_head_person_email) {
            this.branch_head_person_email = branch_head_person_email;
        }

        public String getBranch_contact_number() {
            return branch_contact_number;
        }

        public void setBranch_contact_number(String branch_contact_number) {
            this.branch_contact_number = branch_contact_number;
        }

        public String getBranch_email() {
            return branch_email;
        }

        public void setBranch_email(String branch_email) {
            this.branch_email = branch_email;
        }
    }

    class Dealer implements Serializable {
        @SerializedName("id")
        private String id;

        @SerializedName("i_distributor_id")
        private String i_distributor_id;

        @SerializedName("v_dealer_id")
        private String dealer_id;

        @SerializedName("v_name")
        private String name;

        @SerializedName("v_email_id")
        private String email_id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getI_distributor_id() {
            return i_distributor_id;
        }

        public void setI_distributor_id(String i_distributor_id) {
            this.i_distributor_id = i_distributor_id;
        }

        public String getDealer_id() {
            return dealer_id;
        }

        public void setDealer_id(String dealer_id) {
            this.dealer_id = dealer_id;
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
    }

    public class Customer implements Serializable {
        @SerializedName("id")
        private String id;

        @SerializedName("i_distributor_id")
        private String distributor_id;

        @SerializedName("i_branch_id")
        private String branch_id;

        @SerializedName("i_dealer_id")
        private String dealer_id;

        @SerializedName("v_customer_id")
        private String customer_id;

        @SerializedName("v_name")
        private String name;

        @SerializedName("v_email_id")
        private String email_id;

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

        @SerializedName("v_latitude")
        private String latitude;

        @SerializedName("v_longitude")
        private String longitude;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDistributor_id() {
            return distributor_id;
        }

        public void setDistributor_id(String distributor_id) {
            this.distributor_id = distributor_id;
        }

        public String getBranch_id() {
            return branch_id;
        }

        public void setBranch_id(String branch_id) {
            this.branch_id = branch_id;
        }

        public String getDealer_id() {
            return dealer_id;
        }

        public void setDealer_id(String dealer_id) {
            this.dealer_id = dealer_id;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
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
    }

    public class CylinderType implements Serializable {
        @SerializedName("id")
        private String id;

        @SerializedName("v_code")
        private String code;

        @SerializedName("v_name")
        private String name;

        @SerializedName("t_description")
        private String description;

        @SerializedName("d_price")
        private String price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

    public class ScheduleDeliveryTiming implements Serializable {
        @SerializedName("id")
        private String id;

        @SerializedName("v_name")
        private String name;

        @SerializedName("t_start_time")
        private String start_time;

        @SerializedName("t_end_time")
        private String end_time;

        @SerializedName("t_description")
        private String description;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
