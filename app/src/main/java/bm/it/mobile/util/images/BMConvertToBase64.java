package bm.it.mobile.util.images;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class BMConvertToBase64 {

    private Context mContext;

    public BMConvertToBase64(Context context) {
        this.mContext = context;
    }

    public String fromImagePath(String path) {
        return this.fromBitmap(new BMConvertToBitmap(mContext).fromImagePath(path));
    }

    public String fromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return this.fromBytes(byteArray);
    }

    public String fromResizeImagePath(String path) {
        Bitmap bitmap = new BMConvertToBitmap(mContext).fromImagePath(path);
        return this.fromResizeBitmap(bitmap);
    }

    public String fromResizeBitmap(Bitmap bitmap) {
        return this.fromBitmap(new BMConvertToBitmap(mContext).resizeImage(bitmap));
    }

    public String fromURI(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = mContext.getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String columnRealPath = cursor.getString(columnIndex);
            cursor.close();
            return columnRealPath;
        }
        return "";
    }

    public String fromBytes(byte[] bytes) {
        return Base64.encodeToString(bytes, Base64.NO_WRAP);
    }
}