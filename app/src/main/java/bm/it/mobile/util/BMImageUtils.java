package bm.it.mobile.util;

import android.content.Context;

import java.io.IOException;

import bm.it.mobile.util.images.BMConvertImageUnits;
import bm.it.mobile.util.images.BMConvertToBase64;
import bm.it.mobile.util.images.BMConvertToBitmap;
import bm.it.mobile.util.images.BMConvertToByte;
import bm.it.mobile.util.images.BMConvertToDrawable;
import bm.it.mobile.util.images.BMConvertToFile;
import bm.it.mobile.util.images.BMConvertToRoundedBitmapDrawable;
import bm.it.mobile.util.images.BMConvertToURI;

public class BMImageUtils {

    private Context mContext;

    public BMImageUtils(Context context) {
        this.mContext = context;
    }

    public BMConvertToBitmap toBitmap() {
        return new BMConvertToBitmap(mContext);
    }

    public BMConvertToBase64 toBase64() {
        return new BMConvertToBase64(mContext);
    }

    public BMConvertToByte toByte() {
        return new BMConvertToByte(mContext);
    }

    public BMConvertToRoundedBitmapDrawable toRoundedBitmapDrawable() {
        return new BMConvertToRoundedBitmapDrawable(mContext);
    }

    public BMConvertToDrawable toDrawable() {
        return new BMConvertToDrawable(mContext);
    }

    public BMConvertToURI toURI() {
        return new BMConvertToURI(mContext);
    }

    public BMConvertImageUnits toImageUnits() {
        return new BMConvertImageUnits(mContext);
    }

    public BMConvertToFile toFile() throws IOException {
        return new BMConvertToFile(mContext);
    }
}
