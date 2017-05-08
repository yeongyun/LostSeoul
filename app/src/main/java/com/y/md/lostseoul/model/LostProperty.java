package com.y.md.lostseoul.model;

import android.support.annotation.NonNull;

import com.y.md.lostseoul.common.Constants;

/**
 * Created by prompt32 on 2017-05-02.
 */

public class LostProperty implements Constants {
    private long id = 0;
    private String name = "";
    private String date = "";
    private String takePlace = "";
    private String contact = "";
    private String category = "";
    private String getPosition = "";
    private String getPlace = "";
    private String getThings = "";
    private String status = "";
    private String imgUrl = "";

    public LostProperty(@NonNull long id, @NonNull String name, @NonNull String date, @NonNull String takePlace, @NonNull String contact, @NonNull String category) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.takePlace = takePlace;
        this.contact = contact;
        this.category = category;
    }

    public void setGetPosition(String getPosition) {
        this.getPosition = getPosition;
    }
    public void setGetThings(String getThings) {
        this.getThings = getThings;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public void setGetPlace(String getPlace) {
        this.getPlace = getPlace;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTakePlace() {
        return takePlace;
    }

    public String getContact() {
        return contact;
    }

    public String getCategory() {
        return category;
    }

    public String getGetPosition() {
        return getPosition;
    }

    public String getGetThings() {
        return getThings;
    }

    public String getStatus() {
        return status;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getGetPlace() {
        return getPlace;
    }

    public int getType() {
        if(imgUrl != null && imgUrl.length() > 0 && imgUrl.startsWith("http")) {
            return TYPE_ROW_IMAGE;
        } else {
            return TYPE_ROW_TEXT;
        }
    }
}
