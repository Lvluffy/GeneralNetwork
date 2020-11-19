package com.luffy.apilib.interceptor.parameter;

import android.util.Log;

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
    public final String TAG = BaseLayerParameterInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.i(TAG, "Parameter intercept is called");
        Request request = chain.request();
        return chain.proceed(interceptParameter(request));
    }

    public abstract Request interceptParameter(Request request) throws IOException;
}
