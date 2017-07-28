package com.flame.gongjiao.net;

import com.flame.gongjiao.util.Global;
import okhttp3.*;

import java.io.IOException;

public class BusTimeInfoNet {

    public static String getRunBusTime(String xl, String sxx) {
        return getInfo(xl, sxx, "/GetRunBusTime");
    }

    public static String getNextBusTime(String xl, String sxx) {
        return getInfo(xl, sxx, "/GetNextBusTime");
    }

    private static String getInfo(String xl, String sxx, String address) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("xl", xl)
                .add("sxx", sxx)
                .build();
        Request request = new Request.Builder()
                .url(Global.getSocAddress() + address)
                .put(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getComeTime(String xl, String zd, String sxx) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("xl", xl)
                .add("sxx", sxx)
                .add("zd", zd)
                .build();
        Request request = new Request.Builder()
                .url(Global.getSocAddress() + "/SumComeTime")
                .put(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
