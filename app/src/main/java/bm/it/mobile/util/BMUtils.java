package bm.it.mobile.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BMUtils {

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected();
    }

    @Deprecated
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

    @Deprecated
    public static void textViewOnTouch(TextView textView, final int colorDefault) {
        textViewOnTouch(textView, colorDefault, Color.GRAY);
    }

    @Deprecated
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

    public static LinearLayout.LayoutParams setLayoutParamsInImageView(Context context, int margin, boolean isMarginButton) {
        return setLayoutParamsInImageView(context, margin, isMarginButton, 25);
    }

    public static LinearLayout.LayoutParams setLayoutParamsInImageView(Context context, int margin, boolean isMarginButton, int size) {
        ImageUtils imageUtils = new ImageUtils(context);
        int imageSize = (int) imageUtils.toImageUnits().convertDpToPixel(size);
        int marginButton = (int) imageUtils.toImageUnits().convertDpToPixel(margin);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(imageSize, imageSize);
        layoutParams.setMargins(0, 0, 0, marginButton);
        if (isMarginButton) {
            layoutParams.gravity = Gravity.BOTTOM;
        } else {
            layoutParams.gravity = Gravity.CENTER;
        }
        return layoutParams;
    }
}
