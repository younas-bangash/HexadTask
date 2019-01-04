package com.hexad.movietask.model;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Muhammad Younas
 * Created Date : 1/4/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class BookDetail {
    @SerializedName("kind")
    public String kind;

    @SerializedName("id")
    public String id;

    @SerializedName("etag")
    public String etag;

    @SerializedName("selfLink")
    public String selfLink;

    @SerializedName("volumeInfo")
    public VolumeInfo volumeInfo;

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        /**  loading book images using Glide library **/
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }
}
