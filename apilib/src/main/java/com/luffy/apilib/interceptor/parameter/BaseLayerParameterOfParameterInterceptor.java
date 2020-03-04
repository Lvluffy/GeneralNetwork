package com.luffy.apilib.interceptor.parameter;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 参数拦截器之Parameter
 */
public abstract class BaseLayerParameterOfParameterInterceptor extends BaseLayerParameterInterceptor {
    @Override
    public Request interceptParameter(Interceptor.Chain chain) throws IOException {
        /*---------------Parameter式添加参数---------------*/
        Request request = chain.request();
        HttpUrl httpUrl = request.url();
        Request.Builder requestBuilder = request.newBuilder().url(addPublicParameter(httpUrl.newBuilder()));
        return requestBuilder.build();
    }

    /**
     * 添加公共Parameter
     *
     * @param httpUrlBuilder
     * @throws IOException
     */
    public abstract HttpUrl addPublicParameter(HttpUrl.Builder httpUrlBuilder) throws IOException;
}
