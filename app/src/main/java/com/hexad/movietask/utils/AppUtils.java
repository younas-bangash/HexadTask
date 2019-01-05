package com.hexad.movietask.utils;

/**
 * This class will contains all the utalities functions
 * <p>
 * Created by Muhammad Younas
 * Created Date : 1/6/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class AppUtils {
    /**
     * This function will return the item for which rating will be changed
     *
     * @return
     */
    public static int getPosition() {
        final int min = 0;
        final int max = 9;
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    /**
     * This function will return the rating
     *
     * @return
     */
    public static int getRating() {
        final int minRating = 0;
        final int maxRating = 5;
        return minRating + (int) (Math.random() * ((maxRating - minRating) + 1));
    }
}
