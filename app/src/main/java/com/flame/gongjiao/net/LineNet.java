package com.flame.gongjiao.net;

import com.flame.gongjiao.util.RetrofitUtil;
import com.flame.gongjiao.bean.LineBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.POST;

public class LineNet {

    public static void getLine(final callback c) {
        Retrofit retrofit = RetrofitUtil.getBsInstance();

        LineService service = retrofit.create(LineService.class);
        final Call<LineBean> call = service.getLine();
        call.enqueue(new Callback<LineBean>() {
            @Override
            public void onResponse(Call<LineBean> call, Response<LineBean> response) {
                c.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<LineBean> call, Throwable throwable) {

            }
        });
    }

    interface LineService {
        @POST("/sdhyschedule/PhoneQueryAction!getLineInfo.shtml")
        Call<LineBean> getLine();
    }

    public interface callback {
        void onResponse(LineBean data);

    }
}
