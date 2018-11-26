package com.copyweather.android.util;

import android.text.TextUtils;
import android.util.Log;

import com.copyweather.android.db.City;
import com.copyweather.android.db.County;
import com.copyweather.android.db.Province;
import com.copyweather.android.gson.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Creator: Xing
 * Time on: 2018/11/25.
 */
public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            JSONArray allProvinces = null;
            try {
                allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject object = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(object.getString("name"));
                    province.setProvinceCode(object.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }


    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            JSONArray allCites = null;
            try {
                allCites = new JSONArray(response);
                for (int i = 0; i < allCites.length(); i++) {
                    JSONObject object = allCites.getJSONObject(i);
                    City city = new City();
                    city.setCityName(object.getString("name"));
                    city.setCityCode(object.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }


    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            JSONArray allCounties = null;
            try {
                allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject object = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(object.getString("name"));
                    county.setWeatherId(object.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();

                    Log.i("TAH", "----------------------------" + object.getString("weather_id"));
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }


    /*将weather解析成实体类*/
    public static Weather handleWeatherResponse(String response) {
        try {
            JSONObject object = new JSONObject(response);

            JSONArray array = object.getJSONArray("HeWeather");

            String weatherContent = array.getJSONObject(0).toString();

            return new Gson().fromJson(weatherContent, Weather.class);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
}
