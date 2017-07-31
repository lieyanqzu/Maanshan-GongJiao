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

    private static String getInfo(final String xl, final String sxx, final String address) {
        final StringBuffer buffer = new StringBuffer();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
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
                    buffer.append(client.newCall(request).execute().body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

    private static String getComeTime(final String xl, final String zd, final String sxx) {
        final StringBuffer buffer = new StringBuffer();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
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
                    buffer.append(client.newCall(request).execute().body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
}
