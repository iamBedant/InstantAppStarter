package com.iambedant.instantappstarter.data.remote.model;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iambedant.instantappstarter.data.remote.rave.RaveValidatorFactory;
import com.uber.rave.annotation.Validated;

/**
 * Created by @iamBedant on 13/08/17.
 */

@Validated(factory = RaveValidatorFactory.class)
public class UserResponse {

    @SerializedName("AadharReturnCode")
    @Expose
    private String aadharReturnCode;

    @NonNull
    @SerializedName("ReturnMsg")
    @Expose
    private String returnMsg;

    @SerializedName("UDP")
    @Expose
    private Object uDP;

    @SerializedName("ReturnCode")
    @Expose
    private String returnCode;

    @SerializedName("KYCStatus")
    @Expose
    private String kYCStatus;

    public String getAadharReturnCode() {
        return aadharReturnCode;
    }

    public void setAadharReturnCode(String aadharReturnCode) {
        this.aadharReturnCode = aadharReturnCode;
    }

    @NonNull
    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(@NonNull String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public Object getUDP() {
        return uDP;
    }

    public void setUDP(Object uDP) {
        this.uDP = uDP;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getKYCStatus() {
        return kYCStatus;
    }

    public void setKYCStatus(String kYCStatus) {
        this.kYCStatus = kYCStatus;
    }

}
