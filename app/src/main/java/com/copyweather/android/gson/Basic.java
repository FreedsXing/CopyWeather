package com.copyweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Creator: Xing
 * Time on: 2018/11/25.
 */
public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;
    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
