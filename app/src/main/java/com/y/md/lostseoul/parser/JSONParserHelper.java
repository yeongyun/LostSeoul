package com.y.md.lostseoul.parser;

import com.y.md.lostseoul.common.Constants;
import com.y.md.lostseoul.common.Util;
import com.y.md.lostseoul.model.LostProperty;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by prompt32 on 2017-04-27.
 */

public class JSONParserHelper implements Constants {

    public List<LostProperty> parsePropertyList(String response) throws JSONException {
        Util util = new Util();

        List<LostProperty> lostList;
        JSONObject jsonResponse = new JSONObject(response);
        if(!jsonResponse.isNull(JSON_PARAM_LISTLOSTARTICLESERVICE)) {
            JSONObject jsonListLostArticleService = jsonResponse.getJSONObject(JSON_PARAM_LISTLOSTARTICLESERVICE);
            int totalCount = jsonListLostArticleService.getInt(JSON_PARAM_LISTTOTALCOUNT);
            String resultCode = jsonListLostArticleService.getJSONObject(JSON_PARAM_RESULT).getString(JSON_PARAM_CODE);
            String resultMessage = jsonListLostArticleService.getJSONObject(JSON_PARAM_RESULT).getString(JSON_PARAM_MESSAGE);

            JSONArray jsonRows = jsonListLostArticleService.getJSONArray(JSON_PARAM_ROW);
            if (jsonRows != null && jsonRows.length() > 0) {
                lostList = new ArrayList<>();
                for (int i = 0; i < jsonRows.length(); i++) {
                    JSONObject jsonRow = jsonRows.getJSONObject(i);
                    long id = jsonRow.getLong(JSON_PARAM_ID);
                    String name = jsonRow.getString(JSON_PARAM_GETNAME);
                    String date = "";
                    try {
                        date = util.changeDateFormat(jsonRow.getString(JSON_PARAM_GETDATE));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String takePlace = jsonRow.getString(JSON_PARAM_TAKEPLACE);
                    String contact = jsonRow.getString(JSON_PARAM_CONTACT);
                    String category = jsonRow.getString(JSON_PARAM_CATE);

                    LostProperty lostProperty = new LostProperty(id, name, date, takePlace, contact, category);
                    lostProperty.setGetPosition(jsonRow.getString(JSON_PARAM_GETPOSITION));
                    lostProperty.setGetPlace(jsonRow.getString(JSON_PARAM_GETPLACE));
                    lostProperty.setGetThings(jsonRow.getString(JSON_PARAM_GETTHINGS));
                    lostProperty.setStatus(jsonRow.getString(JSON_PARAM_STATUS));
                    lostProperty.setImgUrl(jsonRow.getString(JSON_PARAM_IMAGEURL));

                    lostList.add(lostProperty);
                }
                return lostList;
            }
        }
        return null;
    }
}
