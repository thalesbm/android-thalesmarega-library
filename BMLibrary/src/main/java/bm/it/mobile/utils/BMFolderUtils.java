package bm.it.mobile.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import bm.it.mobile.R;

public class BMFolderUtils {
    private final String TAG = BMFolderUtils.class.getSimpleName();

    private Context mContext;
    private File mFile;
    private String mPath;

    public BMFolderUtils(Context context) throws IOException {
        this.mContext = context;
        this.createDirIfNotExists();
    }

    private void createDirIfNotExists() throws IOException {
        mPath = Environment.getExternalStorageDirectory() + "/" + mContext.getString(R.string.app_name);

        mFile = this.createDirIfNotExists(mPath);
    }

    public boolean removeImageFileFromSD(String fileName) {
        File file = new File(getFile().getAbsolutePath(), fileName + ".png");
        return file.delete();
    }

    public boolean removeImageVideoFromSD(String fileName) {
        File file = new File(getFile().getAbsolutePath(), fileName + ".mp4");
        return file.delete();
    }

    private File createDirIfNotExists(String path) {
        File file = new File(path);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.e(TAG, "Ocorreu um problema ao criar o diretorio: " + path);
            }
        }
        return file;
    }

    public void removeAllFilesFromFolder(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                removeAllFilesFromFolder(child);
            }
        }
        fileOrDirectory.delete();
    }

    public String getMainPath() {
        return mPath;
    }

    public File getFile() {
        return mFile;
    }
}
