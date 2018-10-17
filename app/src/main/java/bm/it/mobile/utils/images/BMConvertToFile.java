package bm.it.mobile.utils.images;

import android.content.Context;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import bm.it.mobile.utils.BMFolderUtils;

public class BMConvertToFile {

    private Context mContext;
    private BMFolderUtils mFolderUtils;

    public BMConvertToFile(Context context) throws IOException {
        this.mContext = context;
        this.mFolderUtils = new BMFolderUtils(mContext);
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
