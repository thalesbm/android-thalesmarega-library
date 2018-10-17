package bm.it.mobile.utils.images;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

public class BMConvertToByte {

    private Context mContext;

    public BMConvertToByte(Context context) {
        this.mContext = context;
    }

    public byte[] fromBase64(String base64) {
        Bitmap bitmap = new BMConvertToBitmap(mContext).fromBase64(base64);
        return this.fromBitmap(bitmap);
    }

    public byte[] fromBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int tam = 50;
            boolean compressed;
            do {
                compressed = bitmap.compress(Bitmap.CompressFormat.JPEG, tam, outputStream);
                tam = tam - 10;
            } while (!compressed && tam != 0);
            return outputStream.toByteArray();
        }
        return null;
    }
}
