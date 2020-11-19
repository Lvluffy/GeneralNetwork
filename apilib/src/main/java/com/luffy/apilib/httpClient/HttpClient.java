package com.luffy.apilib.httpClient;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpClient implements IHttpClient {

    private IHttpClient mIHttpClient;

    private HttpClient(OkHttpClient client) {
        mIHttpClient = new OkHttpClientImpl(client);
    }

    public static HttpClient getInstance(OkHttpClient client) {
        return new HttpClientHolder(client).httpClient;
    }

    private static class HttpClientHolder {

        private static HttpClient httpClient;

        public HttpClientHolder(OkHttpClient client) {
            httpClient = new HttpClient(client);
        }
    }

    @Override
    public Response execute(Request request) throws IOException {
        return mIHttpClient.execute(request);
    }

    @Override
    public void enqueue(Request request, Callback responseCallback) {
        mIHttpClient.enqueue(request, responseCallback);
    }

    @Override
    public void cancel(Request request) {
        if (request != null) {
            mIHttpClient.cancel(request);
        }
    }
}
