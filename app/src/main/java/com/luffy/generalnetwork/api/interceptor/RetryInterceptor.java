package com.luffy.generalnetwork.api.interceptor;

import com.luffy.apilib.interceptor.retry.BaseLayerRetryInterceptor;

public class RetryInterceptor extends BaseLayerRetryInterceptor {
    public RetryInterceptor() {
        super(2);
    }
}
