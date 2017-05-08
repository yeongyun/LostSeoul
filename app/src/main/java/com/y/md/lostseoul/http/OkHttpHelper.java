package com.y.md.lostseoul.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by prompt32 on 2017-04-28.
 */

public class OkHttpHelper {

    public void getLostList(String type, Callback callback) {
        String testUrl = "http://openAPI.seoul.go.kr:8088/734253595079656f36387947586e69/json/ListLostArticleService/1/100/" + type;

        OkHttpClient client = new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url(testUrl).build();
        client.newCall(request).enqueue(callback);
    }
}
