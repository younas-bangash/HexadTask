package com.hexad.movietask.di.builder;

import com.hexad.movietask.view.fragment.SplashFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract SplashFragment contributeSplashFragment();

}
