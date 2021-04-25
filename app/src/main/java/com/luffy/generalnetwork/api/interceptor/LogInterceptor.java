package com.luffy.generalnetwork.api.interceptor;

import android.util.Log;

import com.luffy.apilib.interceptor.log.BaseLayerLogInterceptor;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Created by lvlufei on 2018/11/3
 *
 * @desc 日志拦截器
 */
public class LogInterceptor extends BaseLayerLogInterceptor {

    @Override
    public void interceptRequest(Request request) throws IOException {
        Log.i(TAG, String.format("request method == %s", request.method()));
        Log.i(TAG, String.format("request url == %s", request.url()));
        Log.i(TAG, String.format("request headers == %s", request.headers().toString()));

        RequestBody requestBody = request.body();
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        Log.i(TAG, String.format("request body == %s", buffer.readString(Charset.forName("UTF-8"))));


        HttpUrl httpUrl = request.url();
        for (int i = 0; i < httpUrl.querySize(); i++) {
            Log.i(TAG, String.format("request parameter %s == %s", httpUrl.queryParameterName(i), httpUrl.queryParameterValue(i)));
        }
    }

    @Override
    public void interceptResponse(Response response) throws IOException {
        Log.i(TAG, String.format("response body == %s", response.peekBody(1024 * 1024).string()));
    }
}
