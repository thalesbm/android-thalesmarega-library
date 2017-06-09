package bm.it.mobile.util;

import android.os.Parcel;

import java.util.Date;

public class ParcelableUtils {

    public static String readValueToString(Parcel in) {
        Object value = in.readValue(String.class.getClassLoader());
        return (value != null) ? (String) value : null;
    }

    public static Long readValueToLong(Parcel in) {
        Object value = in.readValue(Long.class.getClassLoader());
        return (value != null) ? (Long) value : null;
    }

    public static Boolean readValueToBoolean(Parcel in) {
        Object value = in.readValue(Boolean.class.getClassLoader());
        return (value != null) ? (Boolean) value : null;
    }

    public static Date readValueToDate(Parcel in) {
        Object value = in.readValue(Long.class.getClassLoader());
        return value != null ? new Date((Long) value) : null;
    }

    public static Integer readValueToInteger(Parcel in) {
        Object value = in.readValue(Integer.class.getClassLoader());
        return value != null ? (Integer) value : null;
    }

    public static byte[] readValueToByte(Parcel in) {
        Object value = in.readValue(byte[].class.getClassLoader());
        return value != null ? (byte[]) value : null;
    }

    public static Long writeValueToDate(Date value) {
        return (Long) (value != null ? value.getTime() : value);
    }

    public static Long writeValueToBoolean(Boolean value) {
        return (long) (value == true ? 0 : 1);
    }
}
