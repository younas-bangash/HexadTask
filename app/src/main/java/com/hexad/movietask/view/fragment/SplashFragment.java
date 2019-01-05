package com.hexad.movietask.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hexad.movietask.R;
import com.hexad.movietask.databinding.FragmentSplashBinding;
import com.hexad.movietask.utils.FragmentUtils;
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
        if (null != getActivity() &&
                null != ((AppCompatActivity) getActivity()).getSupportActionBar()) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_splash;
    }

    @Override
    protected void observeLiveData() {
        viewModel.getSplashTimerFinish().observe(this, isTimerFinish ->
                FragmentUtils.replaceFragment((AppCompatActivity) getActivity(),
                        BookListFragment.newInstance(), R.id.fragContainer, false,
                        FragmentUtils.FragmentAnimation.TRANSITION_SLIDE_LEFT_RIGHT_WITHOUT_EXIT));
    }

}
