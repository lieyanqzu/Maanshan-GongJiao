package com.flame.gongjiao.net;

import com.flame.gongjiao.util.RetrofitUtil;
import com.flame.gongjiao.bean.LineStationBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class LineStationNet {

    public static void getLineStation(String lineCode, final callback c) {
        Retrofit retrofit = RetrofitUtil.getBsInstance();

        LineStationService service = retrofit.create(LineStationService.class);
        final Call<LineStationBean> call = service.getLineStation(lineCode);
        call.enqueue(new Callback<LineStationBean>() {
            @Override
            public void onResponse(Call<LineStationBean> call, Response<LineStationBean> response) {
                c.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<LineStationBean> call, Throwable t) {

            }
        });
    }

    interface LineStationService {
        @POST("/sdhyschedule/PhoneQueryAction!getLineStation.shtml")
        Call<LineStationBean> getLineStation(@Query("lineCode") String lineCode);
    }

    public interface callback {
        void onResponse(LineStationBean data);

    }
}
