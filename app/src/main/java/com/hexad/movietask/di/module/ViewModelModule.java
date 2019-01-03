package com.hexad.movietask.di.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.hexad.movietask.viewmodel.BookListViewModel;
import com.hexad.movietask.viewmodel.SplashViewModel;
import com.hexad.movietask.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    abstract ViewModel bindsLoginViewModel(SplashViewModel splashViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(BookListViewModel.class)
    abstract ViewModel bindsBookListViewModel(BookListViewModel bookListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
