package com.example.wo.travelt.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.RadioGroup;

/**
 * Created by kk on 2016/8/5.
 */
public class SuperRadioGroup extends RadioGroup{
    private Paint paint;
    private Path path;
    private int mWidth;
    private int mHeight;
    private  static final float RADIO_TRIANGLE_WIDTH=1/6F;
    private int mInitTranslationX;
    private int mTranslationX;
    public SuperRadioGroup(Context context) {
        super(context,null);
    }

    public SuperRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化画笔
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#ff0000"));
        paint.setStyle(Paint.Style.FILL);
        paint.setPathEffect(new CornerPathEffect(3));
    }
    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.translate(mInitTranslationX+mTranslationX,getHeight()+2);
        canvas.drawPath(path,paint);
        canvas.restore();
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth= (int) (w/4*RADIO_TRIANGLE_WIDTH);
        mInitTranslationX=w/4/2-mWidth/2;
        initTriangle();
    }
    //初始化三角形
    private void initTriangle() {
        mHeight=mWidth/2;
        path=new Path();
        path.moveTo(0,0);
        path.lineTo(mWidth,0);
        path.lineTo(mWidth/2,-mHeight);
        path.close();
    }
    //移动三角形
    public void scroll(int position,float offset){
        int tabWidth=getWidth()/4;
        mTranslationX= (int) (tabWidth*offset+position*tabWidth);
        invalidate();
    }
}
