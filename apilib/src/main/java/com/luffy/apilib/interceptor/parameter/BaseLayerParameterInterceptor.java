package com.luffy.apilib.interceptor.parameter;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 参数拦截器
 */
public abstract class BaseLayerParameterInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(interceptParameter(chain));
    }

    public abstract Request interceptParameter(Chain chain) throws IOException;
}
