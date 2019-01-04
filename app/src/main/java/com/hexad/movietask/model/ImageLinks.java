package com.hexad.movietask.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Muhammad Younas
 * Created Date : 1/4/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class ImageLinks {

    @SerializedName("smallThumbnail")
    public String smallThumbnail;

    @SerializedName("thumbnail")
    public String thumbnail;

    public String getSmallThumbnail() {
        return smallThumbnail;
    }
}
