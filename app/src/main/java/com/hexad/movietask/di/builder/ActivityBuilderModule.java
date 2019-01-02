package com.hexad.movietask.di.builder;

import com.hexad.movietask.view.activity.FragmentContainerActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivityBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector(modules = FragmentBuilderModule.class)
    abstract FragmentContainerActivity fragmentContainerActivity();
}
