package com.hexad.movietask.view.fragment;


import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hexad.movietask.R;
import com.hexad.movietask.databinding.FragmentSplashBinding;
import com.hexad.movietask.view.base.BaseFragment;
import com.hexad.movietask.viewmodel.SplashViewModel;


/**
 * A fragment which show the starting screen of the application
 * <p>
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class SplashFragment extends BaseFragment<SplashViewModel, FragmentSplashBinding> {

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    protected Class<SplashViewModel> getViewModel() {
        return SplashViewModel.class;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.startSplashTimer();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_splash;
    }

    @Override
    protected void observeLiveData() {
        viewModel.getSplashTimerFinish().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean isTimerFinish) {

            }
        });
    }

}
