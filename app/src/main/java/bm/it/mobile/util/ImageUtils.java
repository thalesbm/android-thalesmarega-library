package bm.it.mobile.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils {

    private int mOrientation = -1;
    private Context mContext;

    public ImageUtils(Context context) {
        this.mContext = context;
    }

    /**
     * Method to convert image path to bitmap
     *
     * @param path image path
     * @return image bitmap
     */
    public Bitmap convertImagePathToBitmap(String path) {
        return BitmapFactory.decodeFile(path);
    }

    /**
     * Crop the image
     *
     * @param bitmap image bitmap
     * @return image bitmap
     */
    public Bitmap getCroppedBitmap(Bitmap bitmap) {
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

    /**
     * Convert pixel to dp
     *
     * @param num number of pixel
     * @return dp
     */
    public int convertPixelToDp(final int num) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (num * scale + 0.5f);
    }

    /**
     * Convert bytes to bitmap
     *
     * @param bytes image bytes
     * @return image bitmap
     */
    public Bitmap convertByteToBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    /**
     * Save the image in File
     *
     * @param bitmap image bitmap
     * @param file   file to save the image
     * @throws IOException error during the save
     */
    public void saveBitmapInFile(Bitmap bitmap, File file) throws IOException {
        FileOutputStream mFileOutStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, mFileOutStream);
        mFileOutStream.flush();
        mFileOutStream.close();
    }

    /**
     * Convert bitmap to URI
     *
     * @param bitmap image bitmap
     * @return image URI
     */
    public Uri convertBitmapToUri(Bitmap bitmap) {
        String path = MediaStore.Images.Media.insertImage(mContext.getContentResolver(), bitmap, "Title", null);
        return Uri.parse(path);
    }

    /**
     * Convert image bitmap to bytes
     *
     * @param bitmap image bitmap
     * @return image byte[]
     */
    public byte[] convertBitmapToByte(Bitmap bitmap) {
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

    /**
     * Convert DP to pixel
     *
     * @param dp      quantity dp
     * @return quantity px
     */
    public float convertDpToPixel(float dp) {
        Resources resources = mContext.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }


    /**
     * Convert bitmap to base64
     *
     * @param bitmap image bitmap
     * @return base64
     */
    public String convertBitmapToBase64(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.NO_WRAP);
    }

    /**
     * Rotate the image
     *
     * @param path image path
     * @return image bitmap
     */
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

    /**
     * Convert base64 to bitmap
     *
     * @param input base 64
     * @return image bitmap
     * @throws IllegalArgumentException error during the convert
     */
    public Bitmap decodeBase64(String input) throws IllegalArgumentException {
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    /**
     * Get the image by name from the resourse
     * @param imageName image name
     * @return image drawable
     */
    public Drawable getImageFromDrawableFolderByName(String imageName) {
        Resources resources = mContext.getResources();
        final int resourceId = resources.getIdentifier(imageName, "drawable", mContext.getPackageName());
        return ResourcesCompat.getDrawable(mContext.getResources(), resourceId, null);
    }
}
