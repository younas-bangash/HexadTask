package com.hexad.movietask.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhammad Younas
 * Created Date : 1/4/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class VolumeInfo {

    @SerializedName("title")
    public String title;

    @SerializedName("authors")
    public List<String> authors = new ArrayList<>();

    @SerializedName("publisher")
    public String publisher;

    @SerializedName("publishedDate")
    public String publishedDate;

    @SerializedName("description")
    public String description;

    @SerializedName("imageLinks")
    public ImageLinks imageLinks;

    @SerializedName("language")
    public String language;

    @SerializedName("previewLink")
    public String previewLink;

    @SerializedName("infoLink")
    public String infoLink;

    @SerializedName("canonicalVolumeLink")
    public String canonicalVolumeLink;

    @SerializedName("subtitle")
    public String subtitle;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
