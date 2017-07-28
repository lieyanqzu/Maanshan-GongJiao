package com.flame.gongjiao.net;

import com.flame.gongjiao.util.RetrofitUtil;
import com.flame.gongjiao.bean.StationBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.POST;

public class StationNet {

    public static void getStation(final callback c) {
        Retrofit retrofit = RetrofitUtil.getBsInstance();

        StationService service = retrofit.create(StationService.class);
        final Call<StationBean> call = service.getStation();
        call.enqueue(new Callback<StationBean>() {
            @Override
            public void onResponse(Call<StationBean> call, Response<StationBean> response) {
                c.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<StationBean> call, Throwable throwable) {

            }
        });
    }

    interface StationService {
        @POST("/sdhyschedule/PhoneQueryAction!getZDXX.shtml")
        Call<StationBean> getStation();
    }

    public interface callback {
        void onResponse(StationBean data);

    }
}
