
package com.idexcel.termloanservice.modules.chargecoderequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChargeType {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("displayName")
    @Expose
    private String displayName;
    @SerializedName("calculationType")
    @Expose
    private String calculationType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

}
