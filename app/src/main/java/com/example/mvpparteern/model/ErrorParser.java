package com.example.mvpparteern.model;

import com.example.mvpparteern.model.login.Results;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorParser {
    @SerializedName("code")
    @Expose
    public Integer code;
    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("status")
    @Expose
    public String status;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("results")
    @Expose
    public Results results;
}
