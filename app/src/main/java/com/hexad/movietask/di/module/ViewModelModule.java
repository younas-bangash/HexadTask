package com.hexad.movietask.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.hexad.movietask.viewmodel.BookListViewModel;
import com.hexad.movietask.viewmodel.SplashViewModel;
import com.hexad.movietask.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Muhammad Younas
 * Created Date : 1/4/2019.
 * Email Address : engr.younasbangash@gmail.com
 */

@Module
public interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    ViewModel bindsLoginViewModel(SplashViewModel splashViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(BookListViewModel.class)
    ViewModel bindsBookListViewModel(BookListViewModel bookListViewModel);

    @Binds
    ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
