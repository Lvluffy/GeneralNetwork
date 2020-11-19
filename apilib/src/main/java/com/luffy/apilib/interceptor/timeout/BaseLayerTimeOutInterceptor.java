package com.luffy.apilib.interceptor.timeout;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lvlufei on 2020-11-19
 *
 * @name 超时拦截器
 */
public class BaseLayerTimeOutInterceptor implements Interceptor {
    private static final String TAG = BaseLayerTimeOutInterceptor.class.getSimpleName();

    private final int connectTimeout;
    private final int readTimeout;
    private final int writeTimeout;
    private final TimeUnit timeUnit;

    public BaseLayerTimeOutInterceptor(int connectTimeout, int readTimeout, int writeTimeout, TimeUnit timeUnit) {
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
        this.writeTimeout = writeTimeout;
        this.timeUnit = timeUnit;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.i(TAG, "TimeOut intercept is called");
        chain.withConnectTimeout(connectTimeout, timeUnit);
        chain.withReadTimeout(readTimeout, timeUnit);
        chain.withWriteTimeout(writeTimeout, timeUnit);
        Request request = chain.request();
        Response response = chain.proceed(request);
        return response;
    }
}
