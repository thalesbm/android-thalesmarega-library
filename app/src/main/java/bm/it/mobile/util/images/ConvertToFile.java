package bm.it.mobile.util.images;

import android.content.Context;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import bm.it.mobile.util.FolderUtils;

public class ConvertToFile {

    private Context mContext;
    private FolderUtils mFolderUtils;

    public ConvertToFile(Context context) throws IOException {
        this.mContext = context;
        this.mFolderUtils = new FolderUtils(mContext);
    }

    public String fromBytes(byte[] bytes, String fileFormat) throws IOException {
        InputStream input = new ByteArrayInputStream(bytes);

        String path = mFolderUtils.getMainPath() + "/" + new Date().getTime() + "." + fileFormat;

        OutputStream output = output = new FileOutputStream(path);
        byte data[] = new byte[4096];
        int count;
        while ((count = input.read(data)) != -1) {
            output.write(data, 0, count);
        }
        return path;
    }
}
