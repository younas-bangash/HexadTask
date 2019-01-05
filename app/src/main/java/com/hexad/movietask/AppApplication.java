package com.hexad.movietask;

import android.app.Activity;
import android.app.Application;

import com.hexad.movietask.di.components.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class AppApplication extends Application implements HasActivityInjector {

    private static AppApplication sInstance;

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingInjector;

    public static AppApplication getAppContext() {
        return sInstance;
    }

    private static synchronized void setInstance(AppApplication app) {
        sInstance = app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
        setInstance(this);
    }

    private void initializeComponent() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingInjector;
    }
}
