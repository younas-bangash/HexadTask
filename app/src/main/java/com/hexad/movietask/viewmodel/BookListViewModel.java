package com.hexad.movietask.viewmodel;

import android.databinding.Bindable;
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

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

import static com.hexad.movietask.utils.AppUtils.getPosition;
import static com.hexad.movietask.utils.AppUtils.getRating;

/**
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */

public class BookListViewModel extends BaseViewModel {
    private BookRepository bookRepository;
    private boolean automaticAssignerRunning = false;
    private Observer observer = null;
    // Create the Handler object (on the main thread by default)
    private Handler handler = new Handler();
    private Runnable runnableCode;
    private List<BookDetail> updateList = new ArrayList<>();
    public final ObservableList<BookDetail> items = new ObservableArrayList<>();
    private boolean progressBarVisibility = false;

    private OnRatingBarChangeListener onRatingBarChangeListener = (appCompatRatingBar, bookDetail) -> {
        if (null != appCompatRatingBar && null != bookDetail
                && appCompatRatingBar.isPressed() && !isAutomaticAssignerRunning()) {
            bookDetail.setUserRating(String.valueOf(appCompatRatingBar.getRating()));
            updateList.clear();
            for (BookDetail item : items) {
                if (item.getId().equalsIgnoreCase(bookDetail.getId())) {
                    updateList.add(bookDetail);
                } else {
                    updateList.add(item);
                }
            }
            updateList();
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

    @Bindable
    public boolean isProgressBarVisibility() {
        return progressBarVisibility;
    }

    public void setProgressBarVisibility(boolean progressBarVisibility) {
        this.progressBarVisibility = progressBarVisibility;
        notifyPropertyChanged(BR.progressBarVisibility);
    }


    @SuppressWarnings("unchecked")
    private void updateList() {
        bookRepository.getObservable()
                .subscribe(observer);
    }

    public void createObservable() {
        bookRepository.createObservable();
    }

    public void createObserver() {
        observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Object position) {
                items.clear();
                items.addAll(updateList);
                Collections.sort(items);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
                setProgressBarVisibility(false);
            }
        };
    }

    private void startRatingAssigner() {
        // Define the code block to be executed
        runnableCode = new Runnable() {
            @Override
            public void run() {
                // Do something here on the main thread
                // Repeat this the same runnable code block again another 2 seconds
                // 'this' is referencing the Runnable object
                int rating = getRating();
                int pos = getPosition();
                updateList.clear();
                BookDetail bookDetail = items.get(pos);
                for (BookDetail item : items) {
                    if (item.getId().equalsIgnoreCase(bookDetail.getId())) {
                        item.setUserRating(String.valueOf(rating));
                        updateList.add(bookDetail);
                    } else {
                        updateList.add(item);
                    }
                }
                updateList();
                handler.postDelayed(this, 2000);
            }
        };
        // Start the initial runnable task by posting through the handler
        setAutomaticAssignerRunning(true);
        handler.post(runnableCode);
    }

    public void startProcess() {
        if (!isAutomaticAssignerRunning()) {
            startRatingAssigner();
        } else {
            stopRatingAssigner();
        }
    }

    private void stopRatingAssigner() {
        if (null != handler && null != runnableCode) {
            // Removes pending code execution
            handler.removeCallbacks(runnableCode);
            setAutomaticAssignerRunning(false);
        }
    }

    @Bindable
    public boolean isAutomaticAssignerRunning() {
        return automaticAssignerRunning;
    }

    public void setAutomaticAssignerRunning(boolean automaticAssignerRunning) {
        this.automaticAssignerRunning = automaticAssignerRunning;
        notifyPropertyChanged(BR.automaticAssignerRunning);
    }

}
