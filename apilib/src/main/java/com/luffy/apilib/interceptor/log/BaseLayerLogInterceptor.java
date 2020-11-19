package com.luffy.apilib.interceptor.log;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 日志拦截器
 */
public abstract class BaseLayerLogInterceptor implements Interceptor {
    public final String TAG = BaseLayerLogInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.i(TAG, "Log intercept is called");
        Request request = chain.request();
        Response response = chain.proceed(request);
        interceptRequest(request);
        interceptResponse(response);
        return response;
    }

    public abstract void interceptRequest(Request request) throws IOException;

    public abstract void interceptResponse(Response response) throws IOException;
}
