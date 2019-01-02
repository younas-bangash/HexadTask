package com.hexad.movietask.di.components;

import android.app.Application;

import com.hexad.movietask.AppApplication;
import com.hexad.movietask.di.builder.ActivityBuilderModule;
import com.hexad.movietask.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AppModule.class,
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