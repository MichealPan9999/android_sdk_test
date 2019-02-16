package com.example.panzq.a2019_1;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

public class AnimationHelper {
    public static Animation inFromRightAnimation() {
        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT + 1.0f,
                Animation.RELATIVE_TO_PARENT + 0.0f,
                Animation.RELATIVE_TO_PARENT + 0.0f,
                Animation.RELATIVE_TO_PARENT + 0.0f);
        inFromRight.setDuration(550);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }

    public static Animation outToLeftAnimation() {
        Animation outToLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT + 0.0f,
                Animation.RELATIVE_TO_PARENT - 1.0f,
                Animation.RELATIVE_TO_PARENT + 0.0f,
                Animation.RELATIVE_TO_PARENT + 0.0f);
        outToLeft.setDuration(550);
        outToLeft.setInterpolator(new AccelerateInterpolator());
        return outToLeft;
    }

    public static Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT - 1.0f,
                Animation.RELATIVE_TO_PARENT + 0.0f,
                Animation.RELATIVE_TO_PARENT + 0.0f,
                Animation.RELATIVE_TO_PARENT + 0.0f);
        inFromLeft.setDuration(550);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }

    public static Animation outToRightAnimation() {
        Animation outToRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT + 0.0f,
                Animation.RELATIVE_TO_PARENT + 1.0f,
                Animation.RELATIVE_TO_PARENT + 0.0f,
                Animation.RELATIVE_TO_PARENT + 0.0f);
        outToRight.setDuration(550);
        outToRight.setInterpolator(new AccelerateInterpolator());
        return outToRight;
    }
}
