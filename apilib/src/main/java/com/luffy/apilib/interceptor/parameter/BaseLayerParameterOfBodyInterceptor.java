package com.luffy.apilib.interceptor.parameter;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 参数拦截器之Body
 */
public abstract class BaseLayerParameterOfBodyInterceptor extends BaseLayerParameterInterceptor {
    @Override
    public Request interceptParameter(Interceptor.Chain chain) throws IOException {
        /*---------------Body式添加参数---------------*/
        Request request = chain.request();
        if (chain.request().body() instanceof FormBody) {
            FormBody oldFormBody = (FormBody) request.body();
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            //添加旧参数（接口请求参数）
            for (int i = 0; i < (oldFormBody != null ? oldFormBody.size() : 0); i++) {
                formBodyBuilder.add(oldFormBody.encodedName(i), oldFormBody.encodedValue(i));
            }
            //添加公共Body
            addPublicBody(formBodyBuilder);
            //重新build
            RequestBody requestBody = formBodyBuilder.build();
            Request.Builder requestBuilder = request.newBuilder().method(request.method(), requestBody);
            return requestBuilder.build();
        }
        return request;
    }

    /**
     * 添加公共Body
     *
     * @param formBodyBuilder
     * @throws IOException
     */
    public abstract void addPublicBody(FormBody.Builder formBodyBuilder) throws IOException;
}
