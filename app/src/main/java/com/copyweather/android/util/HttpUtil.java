package com.copyweather.android.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Creator: Xing
 * Time on: 2018/11/25.
 */
public class HttpUtil {

    public static void sendOkHttpRequst(String address, okhttp3.Callback callback){

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
