package com.luffy.apilib.httpClient;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public interface IHttpClient {

    /**
     * 同步请求
     *
     * @param request
     * @return
     * @throws IOException
     */
    Response execute(Request request) throws IOException;

    /**
     * 异步请求
     *
     * @param request
     */
    void enqueue(Request request, Callback responseCallback);


    /**
     * 取消
     *
     * @param request
     */
    void cancel(Request request);

}
