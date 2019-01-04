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
    private String title;

    @SerializedName("authors")
    private List<String> authors = new ArrayList<>();

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("publishedDate")
    private String publishedDate;

    @SerializedName("description")
    private String description;

    @SerializedName("imageLinks")
    private ImageLinks imageLinks;

    @SerializedName("language")
    private String language;

    @SerializedName("previewLink")
    private String previewLink;

    @SerializedName("infoLink")
    private String infoLink;

    @SerializedName("canonicalVolumeLink")
    private String canonicalVolumeLink;

    @SerializedName("subtitle")
    private String subtitle;

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }
}
