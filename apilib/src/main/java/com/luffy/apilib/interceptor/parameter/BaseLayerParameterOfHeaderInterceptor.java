package com.luffy.apilib.interceptor.parameter;

import java.io.IOException;

import okhttp3.Request;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 参数拦截器之Header
 */
public abstract class BaseLayerParameterOfHeaderInterceptor extends BaseLayerParameterInterceptor {
    @Override
    public Request interceptParameter(Request request) throws IOException {
        return addPublicHeader(request.newBuilder()).build();
    }

    /**
     * 添加公共Header
     *
     * @param requestBuilder
     * @throws IOException
     */
    public abstract Request.Builder addPublicHeader(Request.Builder requestBuilder) throws IOException;
}
