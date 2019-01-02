package com.hexad.movietask.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hexad.movietask.R;
import com.hexad.movietask.databinding.ActivityFragmentContainerBinding;
import com.hexad.movietask.view.base.BaseActivity;

/**
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class FragmentContainerActivity extends BaseActivity<ActivityFragmentContainerBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_fragment_container;
    }
}
