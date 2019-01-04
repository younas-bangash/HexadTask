package com.hexad.movietask.view.base;

import com.google.gson.Gson;
import com.hexad.movietask.AppApplication;
import com.hexad.movietask.model.BookDetail;
import com.hexad.movietask.model.Items;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class BookRepository {

    @Inject
    BookRepository() {

    }

    /**
     * This function will read the json file from asset and will return list of books
     *
     * @return
     */
    public List<BookDetail> readBookJsonFile() {
        Items items;
        try {
            InputStream is = AppApplication.getAppContext().getAssets().open("booklist.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            items = new Gson().fromJson(new String(buffer, "UTF-8"), Items.class);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        if (null == items) {
            return new ArrayList<>();
        }
        return items.getItems();
    }
}
