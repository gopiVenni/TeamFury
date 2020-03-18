package com.gogas.delivery.ui.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeliveryListResponse extends  BaseResponse{

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public List<Orders> getAssignedOrders(){
        return data.getAssign_orders();
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data{
        @SerializedName("total_orders")
        private int total_orders;

        @SerializedName("page_no")
        private String page_no;

        @SerializedName("limit")
        private String limit;


        @SerializedName("assign_orders")
        List<Orders> assign_orders;


        public int getTotal_orders() {
            return total_orders;
        }

        public void setTotal_orders(int total_orders) {
            this.total_orders = total_orders;
        }

        public String getPage_no() {
            return page_no;
        }

        public void setPage_no(String page_no) {
            this.page_no = page_no;
        }

        public String getLimit() {
            return limit;
        }

        public void setLimit(String limit) {
            this.limit = limit;
        }

        public List<Orders> getAssign_orders() {
            return assign_orders;
        }

        public void setAssign_orders(List<Orders> assign_orders) {
            this.assign_orders = assign_orders;
        }
    }
}
