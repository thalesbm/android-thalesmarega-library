package bm.it.mobile.util.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;

public class ConvertToDrawable {

    private Context mContext;

    public ConvertToDrawable(Context context) {
        this.mContext = context;
    }

    public Drawable fromImageName(String imageName) {
        Resources resources = mContext.getResources();
        final int resourceId = resources.getIdentifier(imageName, "drawable", mContext.getPackageName());
        return ResourcesCompat.getDrawable(mContext.getResources(), resourceId, null);
    }
}
