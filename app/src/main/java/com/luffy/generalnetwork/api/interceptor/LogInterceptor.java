package com.luffy.generalnetwork.api.interceptor;

import android.util.Log;

import com.luffy.apilib.interceptor.log.BaseLayerLogInterceptor;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Response;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 日志拦截器
 */
public class LogInterceptor extends BaseLayerLogInterceptor {

    @Override
    public void interceptRequest() {
        Log.i(TAG, String.format("request url == %s", chain.request().url()));
        Log.i(TAG, String.format("request headers == %s", chain.request().headers().toString()));
        FormBody formBody = (FormBody) chain.request().body();
        for (int i = 0; i < (formBody != null ? formBody.size() : 0); i++) {
            Log.i(TAG, String.format("request bodys %s == %s", formBody.encodedName(i), formBody.encodedValue(i)));
        }
        HttpUrl httpUrl = chain.request().url();
        for (int i = 0; i < httpUrl.querySize(); i++) {
            Log.i(TAG, String.format("request parameter %s == %s", httpUrl.queryParameterName(i), httpUrl.queryParameterValue(i)));
        }
    }

    @Override
    public void interceptResponse(Response response) throws IOException {
        Log.i(TAG, String.format("response body == %s", response.peekBody(1024 * 1024).string()));
    }
}
