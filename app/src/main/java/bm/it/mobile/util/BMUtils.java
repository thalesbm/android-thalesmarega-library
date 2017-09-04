package bm.it.mobile.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BMUtils {

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected();
    }

    public static void imageViewOnTouch(ImageView imageView) {
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ImageView view = (ImageView) v;
                        view.getDrawable().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {
                        ImageView view = (ImageView) v;
                        view.getDrawable().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }

    public static void textViewOnTouch(TextView textView, final int colorDefault) {
        textViewOnTouch(textView, colorDefault, Color.GRAY);
    }

    public static void textViewOnTouch(TextView textView, final int colorDefault, final int selectedDefault) {
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        TextView view = (TextView) v;
                        view.setTextColor(selectedDefault);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {
                        TextView view = (TextView) v;
                        view.setTextColor(colorDefault);
                        break;
                    }
                }
                return false;
            }
        });
    }

    public static Drawable changeLeftImageSize(Context context, int imageID, float size) {
        Drawable drawable = context.getResources().getDrawable(imageID);
        int bound = (int) (drawable.getIntrinsicWidth() * size);
        drawable.setBounds(0, 0, bound, bound);
        return drawable;
    }
}
