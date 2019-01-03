package com.hexad.movietask.utils;

import android.support.annotation.IntDef;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.hexad.movietask.R;


/**
 * Utility class for doing all the fragment related transitions
 * <p>
 * Created by Muhammad Younas
 * Created Date : 1/3/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class FragmentUtils {

    private FragmentUtils() {
        // Private constructor to hide the implicit one
    }

    /**
     * This function will replace the fragment on the container with given animation and will also
     * put the fragment into back stack
     *
     * @param appCompatActivity
     * @param fragment
     * @param id
     * @param addToBackStack
     * @param animationType
     */
    public static void replaceFragment(AppCompatActivity appCompatActivity, Fragment fragment, int id,
                                       boolean addToBackStack, @FragmentAnimation int animationType) {

        if (null == appCompatActivity)
            return;
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (animationType) {
            case FragmentAnimation.TRANSITION_SLIDE_LEFT_RIGHT_WITHOUT_EXIT:
                transaction.setCustomAnimations(R.anim.slide_in_from_rigth, 0);
                break;
            case FragmentAnimation.TRANSITION_NONE:
            default:
                transaction.setCustomAnimations(0, 0);
                break;
        }
        if (addToBackStack)
            transaction.addToBackStack(fragment.getClass().getCanonicalName());
        transaction.replace(id, fragment, fragment.getClass().getCanonicalName());
        transaction.commit();
    }

    @IntDef({FragmentAnimation.TRANSITION_SLIDE_LEFT_RIGHT_WITHOUT_EXIT,
            FragmentAnimation.TRANSITION_NONE})
    @interface FragmentAnimation {
        int TRANSITION_NONE = 0;
        int TRANSITION_SLIDE_LEFT_RIGHT_WITHOUT_EXIT = 1;
    }
}
