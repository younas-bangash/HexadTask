package com.hexad.movietask.di.module;

import android.arch.lifecycle.ViewModelProvider;

import com.hexad.movietask.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModelModule {

//    @Binds
//    @IntoMap
//    @ViewModelKey(LoginViewModel.class)
//    @SuppressWarnings("unused")
//    abstract ViewModel bindsLoginViewModel(LoginViewModel loginViewModel);

    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}
