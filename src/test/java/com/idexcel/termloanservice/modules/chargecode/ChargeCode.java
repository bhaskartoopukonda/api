
package com.idexcel.termloanservice.modules.chargecode;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * @author Shivaraj.Budeppa
 *
 */
public class ChargeCode {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("chargeCode")
    @Expose
    private String chargeCode;
    @SerializedName("transactionCode")
    @Expose
    private Integer transactionCode;
    @SerializedName("sequence")
    @Expose
    private Integer sequence;
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
    private Integer value;
    @SerializedName("autoNewClient")
    @Expose
    private Boolean autoNewClient;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
    }

    public Integer getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(Integer transactionCode) {
        this.transactionCode = transactionCode;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Boolean getAutoNewClient() {
        return autoNewClient;
    }

    public void setAutoNewClient(Boolean autoNewClient) {
        this.autoNewClient = autoNewClient;
    }

}
