package bm.it.mobile.utils.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

public class BMConvertToURI {

    private Context mContext;

    public BMConvertToURI(Context context) {
        this.mContext = context;
    }

    public Uri fromBitmap(Bitmap bitmap) {
        String path = MediaStore.Images.Media.insertImage(mContext.getContentResolver(), bitmap, "Title", null);
        return Uri.parse(path);
    }
}
