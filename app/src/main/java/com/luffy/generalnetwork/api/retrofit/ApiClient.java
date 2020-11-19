package com.luffy.generalnetwork.api.retrofit;


import com.google.gson.Gson;
import com.luffy.generalnetwork.api.interceptor.LogInterceptor;
import com.luffy.generalnetwork.api.interceptor.ParameterInterceptor;
import com.luffy.generalnetwork.api.interceptor.RetryInterceptor;
import com.luffy.generalnetwork.api.interceptor.TimeoutInterceptor;
import com.luffy.generalnetwork.helper.ConstantsHelper;

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

    private ApiClient() {

    }

    public static ApiClient getInstance() {
        return RetrofitClientHelper.mApiClient;
    }

    private static class RetrofitClientHelper {
        private static final ApiClient mApiClient = new ApiClient();
    }

    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new TimeoutInterceptor())
                .addInterceptor(new RetryInterceptor())
                .addInterceptor(new ParameterInterceptor())
                .addInterceptor(new LogInterceptor())
                .build();
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .baseUrl(ConstantsHelper.ServerSecret.HOST)
                .build();
    }

    public <T> T getApiService(Class<T> cla) {
        return getRetrofit().create(cla);
    }

    public ApiService getApiService() {
        return getApiService(ApiService.class);
    }
}
