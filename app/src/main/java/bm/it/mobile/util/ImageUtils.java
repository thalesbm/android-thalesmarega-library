package bm.it.mobile.util;

import android.content.Context;

import java.io.IOException;

import bm.it.mobile.util.images.ConvertImageUnits;
import bm.it.mobile.util.images.ConvertToBase64;
import bm.it.mobile.util.images.ConvertToBitmap;
import bm.it.mobile.util.images.ConvertToByte;
import bm.it.mobile.util.images.ConvertToDrawable;
import bm.it.mobile.util.images.ConvertToFile;
import bm.it.mobile.util.images.ConvertToRoundedBitmapDrawable;
import bm.it.mobile.util.images.ConvertToURI;

public class ImageUtils {

    private Context mContext;

    public ImageUtils(Context context) {
        this.mContext = context;
    }

    public ConvertToBitmap toBitmap() {
        return new ConvertToBitmap(mContext);
    }

    public ConvertToBase64 toBase64() {
        return new ConvertToBase64(mContext);
    }

    public ConvertToByte toByte() {
        return new ConvertToByte(mContext);
    }

    public ConvertToRoundedBitmapDrawable toRoundedBitmapDrawable() {
        return new ConvertToRoundedBitmapDrawable(mContext);
    }

    public ConvertToDrawable toDrawable() {
        return new ConvertToDrawable(mContext);
    }

    public ConvertToURI toURI() {
        return new ConvertToURI(mContext);
    }

    public ConvertImageUnits toImageUnits() {
        return new ConvertImageUnits(mContext);
    }

    public ConvertToFile toFile() throws IOException {
        return new ConvertToFile(mContext);
    }
}
