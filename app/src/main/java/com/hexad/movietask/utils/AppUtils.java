package com.hexad.movietask.utils;

import com.google.gson.Gson;
import com.hexad.movietask.AppApplication;
import com.hexad.movietask.model.BookDetail;
import com.hexad.movietask.model.Items;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.reactivex.annotations.NonNull;

/**
 * This class will contains all the utalities functions
 * <p>
 * Created by Muhammad Younas
 * Created Date : 1/6/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class AppUtils {

    private AppUtils() {
    }

    /**
     * This function will return the item for which rating will be changed
     *
     * @return
     */
    public static int getPosition() {
        return new Random().nextInt(9);
    }

    /**
     * This function will return the rating
     *
     * @return
     */
    public static int getRating() {
        return new Random().nextInt(5);
    }

    /**
     * This function will read the json file from asset and will return list of books
     *
     * @return
     */
    public static @NonNull
    List<BookDetail> readBookJsonFile() {
        Items items;
        try {
            try (InputStream is = AppApplication.getAppContext().getAssets().open("booklist.json")) {
                int size = is.available();
                byte[] buffer = new byte[size];
                int data = is.read(buffer);
                Logs.v("DataRead", String.valueOf(data));
                items = new Gson().fromJson(new String(buffer, "UTF-8"), Items.class);
            }
        } catch (IOException ex) {
            Logs.reportException(ex);
            return new ArrayList<>();
        }

        if (null == items) {
            return new ArrayList<>();
        }
        return items.getItems();
    }
}
