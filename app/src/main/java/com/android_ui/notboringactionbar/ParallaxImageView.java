package com.android_ui.notboringactionbar;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

/**
 * Created by f.laurent on 21/11/13.
 * antoine-merle.com inspiration
 */
public class ParallaxImageView extends android.support.v7.widget.AppCompatImageView {

    private int mCurrentTranslation;

    public ParallaxImageView(Context context) {
        super(context);
    }

    public ParallaxImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ParallaxImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setCurrentTranslation(int currentTranslation) {
        mCurrentTranslation = currentTranslation;
        invalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(0, -mCurrentTranslation / 2)  ;
        super.draw(canvas);
        canvas.restore();
    }
}
