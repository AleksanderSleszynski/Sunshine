package com.example.julian.sunshine.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by julain on 27.10.15.
 */
public class Compass extends View {

    private float direction;

    public Compass(Context context) {
        super(context);
    }

    public Compass(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Compass(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int hSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int wSpecSize = MeasureSpec.getSize(widthMeasureSpec);

        setMeasuredDimension(wSpecSize, hSpecSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int radius;

        if (width > height) {
            radius = (height-4) / 2;
        } else {
            radius = (width-4) / 2;
        }

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setColor(getResources().getColor(R.color.primary));

        canvas.drawCircle(width / 2, height / 2, radius, paint);

        paint.setColor(getResources().getColor(R.color.primary_dark));

        int startX = width/2;
        int startY = height/2;

        float angle = (float) (direction * Math.PI / 180);

        float endX = (float) (startX  + radius * Math.sin(angle));
        float endY = (float) (startY  - radius * Math.cos(angle));

        canvas.drawLine(
                startX,
                startY,
                endX,
                endY,
                paint
        );
    }
        public void update(float dir){
            direction = dir;
            invalidate();
            Log.e("PENIS", "" + direction);
    }
}
