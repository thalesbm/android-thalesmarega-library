package bm.it.mobile.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.view.Gravity;
import android.widget.LinearLayout;

public class BMUtils {

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected();
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
        BMImageUtils imageUtils = new BMImageUtils(context);
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
