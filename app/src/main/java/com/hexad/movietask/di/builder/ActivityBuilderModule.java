package com.hexad.movietask.di.builder;

import com.hexad.movietask.di.module.ViewModelModule;
import com.hexad.movietask.view.activity.FragmentContainerActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module(includes = ViewModelModule.class)
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract FragmentContainerActivity fragmentContainerActivity();
}
