package com.hexad.movietask.di.builder;

import com.hexad.movietask.view.fragment.BookListFragment;
import com.hexad.movietask.view.fragment.SplashFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Muhammad Younas
 * Created Date : 1/4/2019.
 * Email Address : engr.younasbangash@gmail.com
 */

@Module
public interface FragmentBuilderModule {

    @ContributesAndroidInjector
    SplashFragment contributeSplashFragment();

    @ContributesAndroidInjector
    BookListFragment contributeBookListFragment();

}
