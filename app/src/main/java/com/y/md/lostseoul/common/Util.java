package com.y.md.lostseoul.common;

import android.content.Context;

import com.y.md.lostseoul.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by prompt32 on 2017-04-27.
 */

public class Util {

    public String changeDateFormat(String date) throws ParseException {
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
        Date originalDate = originalFormat.parse(date);
        return newFormat.format(originalDate);
    }

    public String changeType(Context context, String type) {
        if(type.equalsIgnoreCase(context.getString(R.string.b1))) {
            return "b1";
        } else if(type.equalsIgnoreCase(context.getString(R.string.b2))) {
            return "b2";
        } else if(type.equalsIgnoreCase(context.getString(R.string.t1))) {
            return "t1";
        } else if(type.equalsIgnoreCase(context.getString(R.string.t2))) {
            return "t2";
        } else if(type.equalsIgnoreCase(context.getString(R.string.s1))) {
            return "s1";
        } else if(type.equalsIgnoreCase(context.getString(R.string.s2))) {
            return "s2";
        } else if(type.equalsIgnoreCase(context.getString(R.string.s3))) {
            return "s3";
        } else {
            return "s4";
        }
    }
}
