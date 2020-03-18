package com.gogas.delivery.ui.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
public class LoginResponse{


    //login response for vehicle details and products in vehicle

    @SerializedName("code")

    private Integer code;
    @SerializedName("msg")

    private String msg;
    @SerializedName("Vehicle_details")

    private VehicleDetails vehicleDetails;
    @SerializedName("Products_in_vehicel")

    private List<ProductsInVehicel> productsInVehicel = null;
    @SerializedName("flag")

    private Boolean flag;

    public int getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public VehicleDetails getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(VehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    public List<ProductsInVehicel> getProductsInVehicel() {
        return productsInVehicel;
    }

    public void setProductsInVehicel(List<ProductsInVehicel> productsInVehicel) {
        this.productsInVehicel = productsInVehicel;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }







    //end response



    /*@SerializedName("data")
    private Data data;

    public DeliveryBoyDetails getDeliveryBoyDetails() {
        return data.getDeliveryBoyDetails();
    }

    public void setData(Data data) {
        this.data = data;
    }

    class Data{
        @SerializedName("deliveryboys_details")
        DeliveryBoyDetails deliveryBoyDetails;

        public DeliveryBoyDetails getDeliveryBoyDetails() {
            return deliveryBoyDetails;
        }

        public void setDeliveryBoyDetails(DeliveryBoyDetails deliveryBoyDetails) {
            this.deliveryBoyDetails = deliveryBoyDetails;
        }
    }*/
}
