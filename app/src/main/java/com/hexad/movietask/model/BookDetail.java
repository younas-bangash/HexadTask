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
public class BookDetail implements Comparable<BookDetail> {
    @SerializedName("kind")
    private String kind;

    @SerializedName("id")
    private String id;

    @SerializedName("etag")
    private String etag;

    @SerializedName("userRating")
    private String userRating;

    @SerializedName("selfLink")
    private String selfLink;

    @SerializedName("volumeInfo")
    private VolumeInfo volumeInfo;

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        /**  loading book images using Glide library **/
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    public String getId() {
        return id;
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public Float getUserRating() {
        return Float.valueOf(userRating);
    }

    @Override
    public int compareTo(BookDetail bookDetail) {
        int compareRating = (int) Float.parseFloat(bookDetail.userRating);
        return compareRating - ((int) Float.parseFloat(this.userRating));
    }
}
