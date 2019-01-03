package com.hexad.movietask.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hexad.movietask.R;
import com.hexad.movietask.databinding.ActivityFragmentContainerBinding;
import com.hexad.movietask.utils.FragmentUtils;
import com.hexad.movietask.view.base.BaseActivity;
import com.hexad.movietask.view.fragment.SplashFragment;

/**
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class FragmentContainerActivity extends BaseActivity<ActivityFragmentContainerBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentUtils.replaceFragment(this, SplashFragment.newInstance(),
                R.id.fragContainer, false, FragmentUtils.FragmentAnimation.TRANSITION_NONE);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_fragment_container;
    }
}
