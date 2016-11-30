package com.example.wo.travelt.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wo.travelt.R;

/**
 * 自定义的吐司
 */
public class MyToast {

    private static Toast mToast;

    private MyToast(Context context, CharSequence text, int duration) {
        View v = LayoutInflater.from(context).inflate(R.layout.my_toast, null);
        TextView textView = (TextView) v.findViewById(R.id.textview1);
        textView.setText(text);
        mToast = new Toast(context);
        mToast.setDuration(duration);
        mToast.setView(v);
    }

    public static MyToast makeText(Context context, CharSequence text, int duration) {
        return new MyToast(context, text, duration);
    }

    private void show() {
        if (mToast != null) {
            mToast.show();
        }
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        if (mToast != null) {
            mToast.setGravity(gravity, xOffset, yOffset);
        }
    }

    public static void shortToast(Context context, String msg) {
        if (mToast == null) {
//            View v = LayoutInflater.from(context).inflate(R.layout.my_toast, null);
//            TextView textView = (TextView) v.findViewById(R.id.textview1);
//            textView.setText(msg);
//            mToast = new Toast(context);
//            mToast.setDuration(Toast.LENGTH_SHORT);
//            mToast.setView(v);

            mToast = Toast.makeText(context,
                    msg,
                    Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

}
