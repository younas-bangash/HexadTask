package com.hexad.movietask.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhammad Younas
 * Created Date : 1/4/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class Items {
    @SerializedName("kind")
    private String kind;

    @SerializedName("totalItems")
    private Integer totalItems;

    @SerializedName("items")
    public List<BookDetail> bookDetailList = new ArrayList<>();

    public List<BookDetail> getItems() {
        return bookDetailList;
    }

    public Integer getTotalItems() {
        return totalItems;
    }
}
