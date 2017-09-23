package bm.it.mobile.util;

import android.content.Context;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.security.MessageDigest;

import bm.it.mobile.util.images.ConvertToBase64;

public class DigestUtils {

    private Context mContext;

    public DigestUtils(Context context) {
        this.mContext = context;
    }

    public String convertFileToDigestSHA256(String path) {
        String digest = null;
        try {
            FileInputStream is = new FileInputStream(path);

            byte[] byteArr = IOUtils.toByteArray(is);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digestByte = md.digest(byteArr);

            digest = new ConvertToBase64(mContext).fromBytes(digestByte);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return digest;
    }
}