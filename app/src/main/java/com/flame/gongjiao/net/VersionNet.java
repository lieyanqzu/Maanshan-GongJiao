package com.flame.gongjiao.net;

import com.flame.gongjiao.util.RetrofitUtil;
import com.flame.gongjiao.bean.VersionBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class VersionNet {

    private final static int VERSION = 13;

    public static void getVersion(final callback c) {
        Retrofit retrofit = RetrofitUtil.getBsInstance();

        VersionService service = retrofit.create(VersionService.class);
        final Call<VersionBean> call = service.getVersion(VERSION);
        call.enqueue(new Callback<VersionBean>() {
            @Override
            public void onResponse(Call<VersionBean> call, Response<VersionBean> response) {
                c.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<VersionBean> call, Throwable throwable) {

            }
        });
    }

    interface VersionService {
        @POST("/sdhyschedule/PhoneQueryAction!getVersion.shtml")
        Call<VersionBean> getVersion(@Query("version") int version);
    }

    public interface callback {
        void onResponse(VersionBean data);
    }
}
