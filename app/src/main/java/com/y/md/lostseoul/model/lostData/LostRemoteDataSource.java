package com.y.md.lostseoul.model.lostData;

import com.y.md.lostseoul.model.LostProperty;
import com.y.md.lostseoul.http.OkHttpHelper;
import com.y.md.lostseoul.parser.JSONParserHelper;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by prompt32 on 2017-05-08.
 */

public class LostRemoteDataSource implements LostDataSource {

    private static LostRemoteDataSource mInstance;
    private OkHttpHelper mOkHttpHelper;
    private JSONParserHelper mJsonParserHelper;

    private static List<LostProperty> LOST_PROPERTIES;

    public static LostRemoteDataSource getInstance() {
        if(mInstance == null) {
            mInstance = new LostRemoteDataSource();
        }
        return mInstance;
    }


    @Override
    public void getList(String type, final LoadLostCallback callback) {
        if(mOkHttpHelper == null) {
            mOkHttpHelper = new OkHttpHelper();
        }

        mOkHttpHelper.getLostList(type, 1, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onDataNotAvailable();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(mJsonParserHelper == null) {
                    mJsonParserHelper = new JSONParserHelper();
                }

                try {
                    List<LostProperty> lostProperties = mJsonParserHelper.parsePropertyList(response.body().string());
                    if(lostProperties == null) {
                        callback.onDataNotAvailable();
                    } else {
                        callback.onListLoaded(lostProperties);
                        LOST_PROPERTIES = lostProperties;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    callback.onDataNotAvailable();
                }
            }
        });
    }
}
