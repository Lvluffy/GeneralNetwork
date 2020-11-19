package com.luffy.apilib.interceptor.retry;

import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lvlufei on 2020-11-19
 *
 * @name 重试拦截器
 */
public class BaseLayerRetryInterceptor implements Interceptor {
    public final String TAG = BaseLayerRetryInterceptor.class.getSimpleName();

    private final int maxRetry;

    public BaseLayerRetryInterceptor(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.i(TAG, "Retry intercept is called");
        Request request = chain.request();
        Response response = chain.proceed(request);
        int count = 1;
        while (needRetry(count, response)) {
            response.close();
            count++;
            response = chain.proceed(request);
        }
        return response;
    }

    /**
     * 是否需要重试
     *
     * @param count
     * @param response
     * @return
     */
    public boolean needRetry(int count, Response response) {
        if (response == null) {
            return false;
        }
        if (response.code() != HttpURLConnection.HTTP_OK && count < maxRetry) {
            Log.i(TAG, "Retry needRetry is called,return true.");
            return true;
        }
        return false;
    }
}