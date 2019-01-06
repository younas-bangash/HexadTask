package com.hexad.movietask.di.builder;

import com.hexad.movietask.di.module.ViewModelModule;
import com.hexad.movietask.view.activity.FragmentContainerActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Muhammad Younas
 * Created Date : 1/4/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
@Module(includes = ViewModelModule.class)
public interface ActivityBuilderModule {
    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    FragmentContainerActivity fragmentContainerActivity();
}
