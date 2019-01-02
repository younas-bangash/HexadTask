package com.hexad.movietask.di.builder;

import com.tawasul.employee.services.view.fragment.LoginFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract LoginFragment contributeLoginFragment();

}
