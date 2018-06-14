package com.example.administrator.ui_make.ui.clock;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Clock extends View{
    private int hour = 1;
    private int hourHandWidth;
    private int hourHandLong;
    private int minute = 2;
    private int minuteHandWidth;
    private int minuteHandLong;
    private int second = 3;
    private int secondHandWidth;
    private int secondHandLong;
    private int radii ;
    private int[] center = null;
    public Clock(Context context) {
        super(context);
    }

    public Clock(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if(width > height) {
            init(height);
        }else {
            init(width);
        }
        center = new int[]{width / 2, height / 2};

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    private void init(int size){

        radii = size / 2;
        hourHandWidth = radii / 10;
        hourHandLong = radii / 2;
        minuteHandWidth = hourHandWidth / 2;
        minuteHandLong = radii * 2 / 3;
        secondHandWidth = minuteHandWidth / 2;
        secondHandLong = radii * 9 / 10;
    }
}
