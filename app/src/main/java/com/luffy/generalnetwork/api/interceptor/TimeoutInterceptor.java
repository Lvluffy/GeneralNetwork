package com.luffy.generalnetwork.api.interceptor;

import com.luffy.apilib.interceptor.timeout.BaseLayerTimeOutInterceptor;

import java.util.concurrent.TimeUnit;

/**
 * Created by lvlufei on 2020-10-13
 *
 * @name 超时拦截器
 */
public class TimeoutInterceptor extends BaseLayerTimeOutInterceptor {

    private static final int DEFAULT_TIMEOUT_MILLISECOND = 10 * 1000;
    private static final int DEFAULT_IO_TIMEOUT_MILLISECOND = 60 * 1000;

    public TimeoutInterceptor() {
        super(DEFAULT_TIMEOUT_MILLISECOND, DEFAULT_IO_TIMEOUT_MILLISECOND, DEFAULT_IO_TIMEOUT_MILLISECOND, TimeUnit.MILLISECONDS);
    }
}
