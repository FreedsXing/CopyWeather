package com.copyweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Creator: Xing
 * Time on: 2018/11/25.
 */
public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String infp;
    }
}
