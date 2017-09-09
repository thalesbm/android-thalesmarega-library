package bm.it.mobile.util.images;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class ConvertImageUnits {

    private Context mContext;

    public ConvertImageUnits(Context context) {
        this.mContext = context;
    }

    public int convertPixelToDp(final int num) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (num * scale + 0.5f);
    }

    public float convertDpToPixel(float dp) {
        Resources resources = mContext.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
