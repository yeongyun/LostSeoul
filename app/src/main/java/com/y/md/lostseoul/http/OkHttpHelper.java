package com.y.md.lostseoul.http;

import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by prompt32 on 2017-04-28.
 */

public class OkHttpHelper {
    private final String API_DOMAIN = "http://openAPI.seoul.go.kr:8088";
    private final String API_KEY = "734253595079656f36387947586e69";
    private final String RESULT_TYPE = "json";
    private final String API_NAME_LOST_ARTICLE = "ListLostArticleService";
    private final int pageSize = 100;

    private OkHttpClient mOkHttpClient;

    public OkHttpHelper() {
        mOkHttpClient = new OkHttpClient.Builder().readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).build();
    }

    public void getLostList(String type, int page, Callback callback) {
        String url = API_DOMAIN + appendWithSlash(API_KEY) + appendWithSlash(RESULT_TYPE) + appendWithSlash(API_NAME_LOST_ARTICLE)
                + appendWithSlash(Integer.toString(page)) + appendWithSlash(Integer.toString(pageSize)) + appendWithSlash(type);

        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

    public String appendWithSlash(String value) {
        return "/" + value;
    }
}
