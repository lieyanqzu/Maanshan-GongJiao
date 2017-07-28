package com.flame.gongjiao.util;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    private static Retrofit bsRetro;
    private static Retrofit socRetro;

    public static Retrofit getBsInstance() {
        if (bsRetro == null) {
            bsRetro = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Global.getBsAddress())
                    .build();
        }
        return bsRetro;
    }

    public static Retrofit getSocInstance() {
        if (socRetro == null) {
            socRetro = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Global.getSocAddress())
                    .build();
        }
        return socRetro;
    }
}
