package com.luffy.apilib.httpClient;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpClientImpl implements IHttpClient {

    private OkHttpClient mClient;

    public OkHttpClientImpl(OkHttpClient mClient) {
        this.mClient = mClient;
    }

    @Override
    public Response execute(Request request) throws IOException {
        Call call = mClient.newCall(request);
        return call.execute();
    }

    @Override
    public void enqueue(Request request, Callback responseCallback) {
        Call call = mClient.newCall(request);
        call.enqueue(responseCallback);
    }

    @Override
    public void cancel(Request request) {
        Dispatcher dispatcher = mClient.dispatcher();
        for (Call call : dispatcher.queuedCalls()) {
            if (request == call.request().tag()) {
                call.cancel();
            }
        }
        for (Call call : dispatcher.runningCalls()) {
            if (request == call.request().tag()) {
                call.cancel();
            }
        }
    }
}
