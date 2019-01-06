package com.hexad.movietask.view.base;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;

import static com.hexad.movietask.utils.AppUtils.getPosition;

/**
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class BookRepository {
    private Observable observable = null;

    @Inject
    BookRepository() {
    }

    @SuppressWarnings("unchecked")
    public void createObservable() {
        observable = Observable.create((ObservableOnSubscribe) emitter -> {
            try {
                emitter.onNext(getPosition());
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }

    public Observable getObservable() {
        return observable;
    }
}
