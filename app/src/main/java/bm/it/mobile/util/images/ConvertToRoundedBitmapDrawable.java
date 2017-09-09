package bm.it.mobile.util.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;

public class ConvertToRoundedBitmapDrawable {

    private Context mContext;

    public ConvertToRoundedBitmapDrawable(Context context) {
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
        Bitmap bitmap = new ConvertToBitmap(mContext).fromByte(bytes);
        return this.fromBitmap(bitmap);
    }

    public RoundedBitmapDrawable fromBase64(String base64) {
        Bitmap bitmap = new ConvertToBitmap(mContext).fromBase64(base64);
        return this.fromBitmap(bitmap);
    }

    public RoundedBitmapDrawable fromDrawable(int id) {
        Bitmap bitmap = new ConvertToBitmap(mContext).fromDrawable(id);
        return this.fromBitmap(bitmap);
    }
}
