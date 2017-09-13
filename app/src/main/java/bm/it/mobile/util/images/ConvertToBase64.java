package bm.it.mobile.util.images;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

public class ConvertToBase64 {

    private Context mContext;

    public ConvertToBase64(Context context) {
        this.mContext = context;
    }

    public String fromImagePath(String path) {
        Bitmap bitmap = new ConvertToBitmap(mContext).fromImagePath(path);
        return this.fromBitmap(bitmap);
    }

    public String fromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return this.fromBytes(byteArray);
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