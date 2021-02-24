
package com.idexcel.termloanservice.modules.chargecoderequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chargecoderequest {

    @SerializedName("chargeCode")
    @Expose
    private String chargeCode;
    @SerializedName("transactionCode")
    @Expose
    private String transactionCode;
    @SerializedName("natSign")
    @Expose
    private NatSign natSign;
    @SerializedName("frequency")
    @Expose
    private Frequency frequency;
    @SerializedName("chargeType")
    @Expose
    private ChargeType chargeType;
    @SerializedName("postingType")
    @Expose
    private PostingType postingType;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("autoNewClient")
    @Expose
    private Boolean autoNewClient;

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public NatSign getNatSign() {
        return natSign;
    }

    public void setNatSign(NatSign natSign) {
        this.natSign = natSign;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public ChargeType getChargeType() {
        return chargeType;
    }

    public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
    }

    public PostingType getPostingType() {
        return postingType;
    }

    public void setPostingType(PostingType postingType) {
        this.postingType = postingType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getAutoNewClient() {
        return autoNewClient;
    }

    public void setAutoNewClient(Boolean autoNewClient) {
        this.autoNewClient = autoNewClient;
    }

}
