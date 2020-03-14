package bm.it.mobile.utils.images;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

public class BMConvertToRoundedBitmapDrawable {

    private Context mContext;

    public BMConvertToRoundedBitmapDrawable(Context context) {
        this.mContext = context;
    }

    public RoundedBitmapDrawable fromFileName(String fileName) {
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(mContext.getResources(), fileName);
        roundedBitmapDrawable.setCircular(true);
        return roundedBitmapDrawable;
    }

    public RoundedBitmapDrawable fromBitmap(Bitmap bitmap) {
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(mContext.getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        return roundedBitmapDrawable;
    }

    public RoundedBitmapDrawable fromByte(byte[] bytes) {
        Bitmap bitmap = new BMConvertToBitmap(mContext).fromByte(bytes);
        return this.fromBitmap(bitmap);
    }

    public RoundedBitmapDrawable fromBase64(String base64) {
        Bitmap bitmap = new BMConvertToBitmap(mContext).fromBase64(base64);
        return this.fromBitmap(bitmap);
    }

    public RoundedBitmapDrawable fromDrawable(int id) {
        Bitmap bitmap = new BMConvertToBitmap(mContext).fromDrawable(id);
        return this.fromBitmap(bitmap);
    }
}
