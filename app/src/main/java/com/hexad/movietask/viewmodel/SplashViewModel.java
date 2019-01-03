package com.hexad.movietask.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import javax.inject.Inject;

/**
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class SplashViewModel extends ViewModel {
    private static final int SPLASH_TIME_OUT = 3000;
    //Live data object to check the splash timer status
    private MutableLiveData<Boolean> splashTimerFinish = new MutableLiveData<>();

    @Inject
    SplashViewModel() {
    }

    /**
     * Function to start the splash timer
     */
    public void startSplashTimer() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                //noinspection unchecked
                getSplashTimerFinish().postValue(true);
            }
        }, SPLASH_TIME_OUT);
    }

    public MutableLiveData<Boolean> getSplashTimerFinish() {
        return splashTimerFinish;
    }

}
