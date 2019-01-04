package com.hexad.movietask.interfacec;

import android.support.v7.widget.AppCompatRatingBar;

import com.hexad.movietask.model.BookDetail;

/**
 * Created by Muhammad Younas
 * Created Date : 1/4/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public interface OnRatingBarChangeListener {
    void onRatingBarChange(AppCompatRatingBar appCompatRatingBar, BookDetail bookDetail);
}
