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
    public String kind;

    @SerializedName("totalItems")
    public Integer totalItems;

    @SerializedName("items")
    public List<BookDetail> items = new ArrayList<>();

    public List<BookDetail> getItems() {
        return items;
    }

    public Integer getTotalItems() {
        return totalItems;
    }
}
