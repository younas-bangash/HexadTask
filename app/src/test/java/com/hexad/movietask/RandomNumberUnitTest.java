package com.hexad.movietask;

import org.junit.Test;

import static com.hexad.movietask.utils.AppUtils.getPosition;
import static org.junit.Assert.assertTrue;

/**
 * Created by Muhammad Younas
 * Created Date : 1/6/2019.
 * Email Address : engr.younasbangash@gmail.com
 */
public class RandomNumberUnitTest {

    @Test
    public void itemPosition_isCorrect() {
        int pos = getPosition();
        int min = 0;
        int max = 10;
        boolean result = (pos >= min && pos < max);
        assertTrue(result);
    }

    @Test
    public void itemRating_isCorrect() {
        int pos = getPosition();
        int min = 0;
        int max = 5;
        boolean result = (pos >= min && pos <= max);
        assertTrue(result);
    }
}
