package bm.it.mobile.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import bm.it.mobile.R;

public class FolderUtils {
    private final String TAG = FolderUtils.class.getSimpleName();

    private Context mContext;
    private File mFile;

    public FolderUtils(Context context) throws IOException {
        this.mContext = context;
        this.createDirIfNotExists();
    }

    private void createDirIfNotExists() throws IOException {
        String mainPath = Environment.getExternalStorageDirectory() + "/" + mContext.getString(R.string.app_name);

        mFile = this.createDirIfNotExists(mainPath);
    }

    public boolean removeFileFromSD(String fileName) {
        File file = new File(getFile().getAbsolutePath(), fileName + ".png");
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

    public File getFile() {
        return mFile;
    }
}
