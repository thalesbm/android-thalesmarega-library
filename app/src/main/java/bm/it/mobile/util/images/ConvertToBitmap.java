package bm.it.mobile.util.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConvertToBitmap {

    private int mOrientation = -1;
    private Context mContext;

    public ConvertToBitmap(Context context) {
        this.mContext = context;
    }

    public Bitmap fromByte(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    public Bitmap fromImagePath(String path) {
        return BitmapFactory.decodeFile(path);
    }

    public Bitmap fromBase64(String input) throws IllegalArgumentException {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    public Bitmap fromDrawable(int id) {
        return BitmapFactory.decodeResource(mContext.getResources(), id);
    }

    public Bitmap getCropped(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    public void saveBitmapInFile(Bitmap bitmap, File file) throws IOException {
        FileOutputStream mFileOutStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, mFileOutStream);
        mFileOutStream.flush();
        mFileOutStream.close();
    }

    public Bitmap rotateImage(String path) {
        Bitmap myBitmap = BitmapFactory.decodeFile(path);
        try {
            ExifInterface exif = new ExifInterface(path);
            int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_270:
                    mOrientation = 270;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    mOrientation = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_90:
                    mOrientation = 90;
                    break;
            }

            Log.v("", "Exif orientation: " + orientation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(mOrientation);

        myBitmap = Bitmap.createBitmap(myBitmap, 0, 0, myBitmap.getWidth(), myBitmap.getHeight(), matrix, true);
        return myBitmap;
    }

    public Bitmap resizeImage(Bitmap largeBitmap) {
        ByteArrayOutputStream imageStream = new ByteArrayOutputStream();
        largeBitmap.compress(Bitmap.CompressFormat.JPEG, 90, imageStream);
        byte[] imageBytes = imageStream.toByteArray();
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }
}
