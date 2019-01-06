package com.hexad.movietask.di.components;

import android.app.Application;

import com.hexad.movietask.AppApplication;
import com.hexad.movietask.di.builder.ActivityBuilderModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Muhammad Younas
 * Created Date : 1/4/2019.
 * Email Address : engr.younasbangash@gmail.com
 */

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class})
public interface AppComponent {
    void inject(AppApplication appApplication);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
