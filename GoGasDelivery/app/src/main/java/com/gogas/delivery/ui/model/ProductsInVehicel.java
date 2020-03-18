package com.gogas.delivery.ui.model;
import com.google.gson.annotations.SerializedName;

public class ProductsInVehicel {
    @SerializedName("i_product_id")

    private String iProductId;
    @SerializedName("i_full_cylinder")

    private String iFullCylinder;
    @SerializedName("i_empty_cylinder")

    private String iEmptyCylinder;
    @SerializedName("i_nob_failure_cylinder")

    private String iNobFailureCylinder;

    public String getIProductId() {
        return iProductId;
    }

    public void setIProductId(String iProductId) {
        this.iProductId = iProductId;
    }

    public String getIFullCylinder() {
        return iFullCylinder;
    }

    public void setIFullCylinder(String iFullCylinder) {
        this.iFullCylinder = iFullCylinder;
    }

    public String getIEmptyCylinder() {
        return iEmptyCylinder;
    }

    public void setIEmptyCylinder(String iEmptyCylinder) {
        this.iEmptyCylinder = iEmptyCylinder;
    }

    public String getINobFailureCylinder() {
        return iNobFailureCylinder;
    }

    public void setINobFailureCylinder(String iNobFailureCylinder) {
        this.iNobFailureCylinder = iNobFailureCylinder;
    }
}
