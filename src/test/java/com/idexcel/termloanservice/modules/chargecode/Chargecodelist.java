
package com.idexcel.termloanservice.modules.chargecode;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * @author Shivaraj.Budeppa
 *
 */
public class Chargecodelist {

    @SerializedName("recordTotal")
    @Expose
    private Integer recordTotal;
    @SerializedName("currentPage")
    @Expose
    private Integer currentPage;
    @SerializedName("pagesTotal")
    @Expose
    private Integer pagesTotal;
    @SerializedName("chargeCodes")
    @Expose
    private List<ChargeCode> chargeCodes = null;

    public Integer getRecordTotal() {
        return recordTotal;
    }

    public void setRecordTotal(Integer recordTotal) {
        this.recordTotal = recordTotal;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPagesTotal() {
        return pagesTotal;
    }

    public void setPagesTotal(Integer pagesTotal) {
        this.pagesTotal = pagesTotal;
    }

    public List<ChargeCode> getChargeCodes() {
        return chargeCodes;
    }

    public void setChargeCodes(List<ChargeCode> chargeCodes) {
        this.chargeCodes = chargeCodes;
    }

}
