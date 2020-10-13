package com.luffy.generalnetwork.api.interceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lvlufei on 2020-10-13
 *
 * @name 超时拦截器
 */
public class TimeoutInterceptor implements Interceptor {
    private static final int DEFAULT_TIMEOUT_MILLISECOND = 10 * 1000;
    private static final int DEFAULT_IO_TIMEOUT_MILLISECOND = 60 * 1000;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        return chain.withConnectTimeout(DEFAULT_TIMEOUT_MILLISECOND, TimeUnit.MILLISECONDS)
                .withReadTimeout(DEFAULT_IO_TIMEOUT_MILLISECOND, TimeUnit.MILLISECONDS)
                .withWriteTimeout(DEFAULT_IO_TIMEOUT_MILLISECOND, TimeUnit.MILLISECONDS)
                .proceed(request);
    }
}
