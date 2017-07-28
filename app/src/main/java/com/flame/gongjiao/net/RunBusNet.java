package com.flame.gongjiao.net;

import com.flame.gongjiao.util.RetrofitUtil;
import com.flame.gongjiao.bean.RunBusBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class RunBusNet {

    public static void getRunBus(String lineCode, String sxx, final callback c) {
        Retrofit retrofit = RetrofitUtil.getSocInstance();

        RunBusService service = retrofit.create(RunBusService.class);
        Call<RunBusBean> call = service.getRunBus(lineCode, sxx);
        call.enqueue(new Callback<RunBusBean>() {
            @Override
            public void onResponse(Call<RunBusBean> call, Response<RunBusBean> response) {
                c.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<RunBusBean> call, Throwable t) {

            }
        });
    }

    interface RunBusService {
        @POST("/")
        Call<RunBusBean> getRunBus(@Query("lineCode") String lineCode, @Query("sxx") String sxx);
    }

    public interface callback {
        void onResponse(RunBusBean data);
    }
}
