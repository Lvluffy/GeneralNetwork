package com.luffy.apilib.interceptor.log;

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
    public Chain chain;

    @Override
    public Response intercept(Chain chain) throws IOException {
        this.chain = chain;
        /*拦截请求*/
        Request request = chain.request();
        interceptRequest();
        /*拦截响应*/
        Response response = chain.proceed(request);
        interceptResponse(response);
        return response;
    }

    public abstract void interceptRequest() throws IOException;

    public abstract void interceptResponse(Response response) throws IOException;
}
