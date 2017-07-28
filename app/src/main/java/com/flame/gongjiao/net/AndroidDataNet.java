package com.flame.gongjiao.net;

import com.flame.gongjiao.bean.AndroidDataBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

import java.util.List;

public class AndroidDataNet {

    public static void getAndroidData(final callback c) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://123.232.38.10:9999")
                .build();

        AndroidDataNet.AndroidDataService service = retrofit.create(AndroidDataNet.AndroidDataService.class);
        final Call<List<AndroidDataBean>> call = service.getAndroidData();
        call.enqueue(new Callback<List<AndroidDataBean>>() {
            @Override
            public void onResponse(Call<List<AndroidDataBean>> call, Response<List<AndroidDataBean>> response) {
                c.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<AndroidDataBean>> call, Throwable throwable) {
            }
        });
    }

    interface AndroidDataService {
        @POST("/androidData")
        Call<List<AndroidDataBean>> getAndroidData();
    }

    public interface callback {
        void onResponse(List<AndroidDataBean> data);
    }
}
