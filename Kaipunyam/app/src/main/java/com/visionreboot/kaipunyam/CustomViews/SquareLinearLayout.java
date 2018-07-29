package com.visionreboot.kaipunyam.CustomViews;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * The imageview of aspect ratio 1:1
 */
public class SquareLinearLayout extends LinearLayout {
    public SquareLinearLayout(Context context) {
        super(context);
    }

    public SquareLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        if (width != height) {
            setMeasuredDimension(width, width);
        }
    }

}
