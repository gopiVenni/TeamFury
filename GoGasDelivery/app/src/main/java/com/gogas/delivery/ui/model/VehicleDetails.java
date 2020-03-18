package com.gogas.delivery.ui.model;
import com.google.gson.annotations.SerializedName;
public class VehicleDetails {
    @SerializedName("id")

    private String id;
    @SerializedName("v_vehicle_id")

    private String vVehicleId;
    @SerializedName("v_password")

    private String vPassword;
    @SerializedName("v_vehicle_type")

    private String vVehicleType;
    @SerializedName("v_name")

    private String vName;
    @SerializedName("v_vehicle_number")

    private String vVehicleNumber;
    @SerializedName("v_capacity")

    private String vCapacity;
    @SerializedName("v_quantity")

    private String vQuantity;
    @SerializedName("v_licence_details")

    private String vLicenceDetails;
    @SerializedName("v_licence_file_path")

    private String vLicenceFilePath;
    @SerializedName("d_licence_expiry_at")

    private String dLicenceExpiryAt;
    @SerializedName("v_driver_assign")

    private String vDriverAssign;
    @SerializedName("i_driver_id")

    private String iDriverId;
    @SerializedName("v_driver_otp")

    private String vDriverOtp;
    @SerializedName("e_status")

    private String eStatus;
    @SerializedName("v_created_employee_type")

    private String vCreatedEmployeeType;
    @SerializedName("v_created_employee_id")

    private String vCreatedEmployeeId;
    @SerializedName("v_updated_employee_type")

    private String vUpdatedEmployeeType;
    @SerializedName("v_updated_employee_id")

    private String vUpdatedEmployeeId;
    @SerializedName("d_created_at")

    private String dCreatedAt;
    @SerializedName("d_updated_at")

    private String dUpdatedAt;
    @SerializedName("i_dealer_id")

    private String iDealerId;
    @SerializedName("i_distributor_id")

    private String iDistributorId;
    @SerializedName("i_district_id")

    private String iDistrictId;
    @SerializedName("i_state_id")

    private String iStateId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVVehicleId() {
        return vVehicleId;
    }

    public void setVVehicleId(String vVehicleId) {
        this.vVehicleId = vVehicleId;
    }

    public String getVPassword() {
        return vPassword;
    }

    public void setVPassword(String vPassword) {
        this.vPassword = vPassword;
    }

    public String getVVehicleType() {
        return vVehicleType;
    }

    public void setVVehicleType(String vVehicleType) {
        this.vVehicleType = vVehicleType;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public String getVVehicleNumber() {
        return vVehicleNumber;
    }

    public void setVVehicleNumber(String vVehicleNumber) {
        this.vVehicleNumber = vVehicleNumber;
    }

    public String getVCapacity() {
        return vCapacity;
    }

    public void setVCapacity(String vCapacity) {
        this.vCapacity = vCapacity;
    }

    public String getVQuantity() {
        return vQuantity;
    }

    public void setVQuantity(String vQuantity) {
        this.vQuantity = vQuantity;
    }

    public String getVLicenceDetails() {
        return vLicenceDetails;
    }

    public void setVLicenceDetails(String vLicenceDetails) {
        this.vLicenceDetails = vLicenceDetails;
    }

    public String getVLicenceFilePath() {
        return vLicenceFilePath;
    }

    public void setVLicenceFilePath(String vLicenceFilePath) {
        this.vLicenceFilePath = vLicenceFilePath;
    }

    public String getDLicenceExpiryAt() {
        return dLicenceExpiryAt;
    }

    public void setDLicenceExpiryAt(String dLicenceExpiryAt) {
        this.dLicenceExpiryAt = dLicenceExpiryAt;
    }

    public String getVDriverAssign() {
        return vDriverAssign;
    }

    public void setVDriverAssign(String vDriverAssign) {
        this.vDriverAssign = vDriverAssign;
    }

    public String getIDriverId() {
        return iDriverId;
    }

    public void setIDriverId(String iDriverId) {
        this.iDriverId = iDriverId;
    }

    public String getVDriverOtp() {
        return vDriverOtp;
    }

    public void setVDriverOtp(String vDriverOtp) {
        this.vDriverOtp = vDriverOtp;
    }

    public String getEStatus() {
        return eStatus;
    }

    public void setEStatus(String eStatus) {
        this.eStatus = eStatus;
    }

    public String getVCreatedEmployeeType() {
        return vCreatedEmployeeType;
    }

    public void setVCreatedEmployeeType(String vCreatedEmployeeType) {
        this.vCreatedEmployeeType = vCreatedEmployeeType;
    }

    public String getVCreatedEmployeeId() {
        return vCreatedEmployeeId;
    }

    public void setVCreatedEmployeeId(String vCreatedEmployeeId) {
        this.vCreatedEmployeeId = vCreatedEmployeeId;
    }

    public String getVUpdatedEmployeeType() {
        return vUpdatedEmployeeType;
    }

    public void setVUpdatedEmployeeType(String vUpdatedEmployeeType) {
        this.vUpdatedEmployeeType = vUpdatedEmployeeType;
    }

    public String getVUpdatedEmployeeId() {
        return vUpdatedEmployeeId;
    }

    public void setVUpdatedEmployeeId(String vUpdatedEmployeeId) {
        this.vUpdatedEmployeeId = vUpdatedEmployeeId;
    }

    public String getDCreatedAt() {
        return dCreatedAt;
    }

    public void setDCreatedAt(String dCreatedAt) {
        this.dCreatedAt = dCreatedAt;
    }

    public String getDUpdatedAt() {
        return dUpdatedAt;
    }

    public void setDUpdatedAt(String dUpdatedAt) {
        this.dUpdatedAt = dUpdatedAt;
    }

    public String getIDealerId() {
        return iDealerId;
    }

    public void setIDealerId(String iDealerId) {
        this.iDealerId = iDealerId;
    }

    public String getIDistributorId() {
        return iDistributorId;
    }

    public void setIDistributorId(String iDistributorId) {
        this.iDistributorId = iDistributorId;
    }

    public String getIDistrictId() {
        return iDistrictId;
    }

    public void setIDistrictId(String iDistrictId) {
        this.iDistrictId = iDistrictId;
    }

    public String getIStateId() {
        return iStateId;
    }

    public void setIStateId(String iStateId) {
        this.iStateId = iStateId;
    }
}
