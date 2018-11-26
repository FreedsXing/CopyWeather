package com.copyweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Creator: Xing
 * Time on: 2018/11/25.
 */
public class Forecast {

    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature{
        public String max;

        public String min;
    }

    public class More{
        @SerializedName("txt_d")
        public String inf0;
    }
}
