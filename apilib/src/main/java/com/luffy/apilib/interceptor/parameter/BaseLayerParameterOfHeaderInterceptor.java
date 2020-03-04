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
    public Request interceptParameter(Chain chain) throws IOException {
        /*---------------Header式添加参数---------------*/
        Request request = chain.request();
        //添加公共Header
        Request.Builder requestBuilder = addPublicHeader(request.newBuilder());
        return requestBuilder.build();
    }

    /**
     * 添加公共Header
     *
     * @param requestBuilder
     * @throws IOException
     */
    public abstract Request.Builder addPublicHeader(Request.Builder requestBuilder) throws IOException;
}
