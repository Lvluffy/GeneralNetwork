package com.luffy.generalnetwork.api.retrofit;


import com.luffy.generalnetwork.BuildConfig;
import com.luffy.generalnetwork.api.interceptor.LogInterceptor;
import com.luffy.generalnetwork.api.interceptor.ParameterInterceptor;
import com.luffy.generalnetwork.helper.ConstantsHelper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 网络（Retrofit）客户端
 */
public class ApiClient {
    /*默认延时时间*/
    private static final long DEFAULT_TIME_OUT = 30 * 1000;
    private static Retrofit mRetrofit;

    private ApiClient() {

    }

    public static ApiClient getInstance() {
        return RetrofitClientHelper.mApiClient;
    }

    private static class RetrofitClientHelper {
        private static ApiClient mApiClient;

        static {
            mApiClient = new ApiClient();
        }
    }

    public Retrofit getRetrofit() {
        if (mRetrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.MINUTES);//连接超时时间
            builder.writeTimeout(DEFAULT_TIME_OUT, TimeUnit.MINUTES);//写操作超时时间
            builder.readTimeout(DEFAULT_TIME_OUT, TimeUnit.MINUTES);//读操作超时时间
            //参数拦截器
            builder.addInterceptor(new ParameterInterceptor());
            //Log信息拦截器
            if (BuildConfig.DEBUG) {
                builder.addInterceptor(new LogInterceptor());
            }
            mRetrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(builder.build())
                    .baseUrl(ConstantsHelper.ServerSecret.HOST + "/")
                    .build();
        }
        return mRetrofit;
    }

    public ApiService getApiService() {
        return getRetrofit().create(ApiService.class);
    }
}
