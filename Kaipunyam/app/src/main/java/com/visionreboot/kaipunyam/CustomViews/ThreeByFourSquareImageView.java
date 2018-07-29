package com.visionreboot.kaipunyam.CustomViews;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * The imageview of aspect ratio 1:1
 */
public class ThreeByFourSquareImageView extends AppCompatImageView {
    public ThreeByFourSquareImageView(Context context) {
        super(context);
    }

    public ThreeByFourSquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThreeByFourSquareImageView(Context context, AttributeSet attrs, int defStyle) {
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
