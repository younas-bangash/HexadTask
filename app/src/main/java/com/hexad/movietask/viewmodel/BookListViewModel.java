package com.hexad.movietask.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.hexad.movietask.BR;
import com.hexad.movietask.R;
import com.hexad.movietask.model.BookDetail;
import com.hexad.movietask.view.base.BookRepository;

import java.util.Collections;

import javax.inject.Inject;

import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class BookListViewModel extends ViewModel {
    public final ObservableList<BookDetail> items = new ObservableArrayList<>();
    public final ItemBinding<BookDetail> itemBinding = ItemBinding.of(BR.item, R.layout.book_item);
    private BookRepository bookRepository;
    private boolean progressBarVisibility = false;


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
