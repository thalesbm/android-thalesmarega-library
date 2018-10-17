package bm.it.mobile.utils.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;

public class BMConvertToDrawable {

    private Context mContext;

    public BMConvertToDrawable(Context context) {
        this.mContext = context;
    }

    public Drawable fromImageName(String imageName) {
        Resources resources = mContext.getResources();
        final int resourceId = resources.getIdentifier(imageName, "drawable", mContext.getPackageName());
        return ResourcesCompat.getDrawable(mContext.getResources(), resourceId, null);
    }
}
