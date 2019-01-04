package com.hexad.movietask.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.os.Handler;

import com.hexad.movietask.BR;
import com.hexad.movietask.R;
import com.hexad.movietask.interfacec.OnRatingBarChangeListener;
import com.hexad.movietask.model.BookDetail;
import com.hexad.movietask.view.base.BookRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class BookListViewModel extends ViewModel {
    private BookRepository bookRepository;
    private List<BookDetail> updateList = new ArrayList<>();
    public final ObservableList<BookDetail> items = new ObservableArrayList<>();
    private boolean progressBarVisibility = false;

    private OnRatingBarChangeListener onRatingBarChangeListener = (appCompatRatingBar, bookDetail) -> {
        if (null != appCompatRatingBar && null != bookDetail) {
            bookDetail.setUserRating(String.valueOf(appCompatRatingBar.getRating()));

            for (BookDetail item : items) {
                if (item.getId().equalsIgnoreCase(bookDetail.getId())) {
                    updateList.add(bookDetail);
                } else {
                    updateList.add(item);
                }
            }

            Handler myHandler = new Handler();
            myHandler.postDelayed(() -> {
                items.clear();
                items.addAll(updateList);
                Collections.sort(items);
            }, 2000);

        }
    };

    public final ItemBinding<BookDetail> itemBinding = ItemBinding.<BookDetail>of(BR.item, R.layout.book_item)
            .bindExtra(BR.ratingBarChangeListener, onRatingBarChangeListener);

    @Inject
    BookListViewModel(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void readBookList() {
        setProgressBarVisibility(true);
        items.addAll(bookRepository.readBookJsonFile());
        Collections.sort(items);
        setProgressBarVisibility(false);
    }

    public boolean isProgressBarVisibility() {
        return progressBarVisibility;
    }

    public void setProgressBarVisibility(boolean progressBarVisibility) {
        this.progressBarVisibility = progressBarVisibility;
    }

}
