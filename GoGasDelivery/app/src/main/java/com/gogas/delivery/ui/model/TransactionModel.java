package com.gogas.delivery.ui.model;

public class TransactionModel {
    private String totalCashCollected;
    private String totalDeliveries;
    private String settlementStatus;
    private String date;

    public TransactionModel(String totalCashCollected,String date, String totalDeliveries, String settlementStatus) {
        this.totalCashCollected = totalCashCollected;
        this.totalDeliveries = totalDeliveries;
        this.settlementStatus = settlementStatus;
        this.date=date;
    }

    public String getTotalCashCollected() {
        return totalCashCollected;
    }

    public void setTotalCashCollected(String totalCashCollected) {
        this.totalCashCollected = totalCashCollected;
    }

    public String getTotalDeliveries() {
        return totalDeliveries;
    }

    public void setTotalDeliveries(String totalDeliveries) {
        this.totalDeliveries = totalDeliveries;
    }

    public String getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(String settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
