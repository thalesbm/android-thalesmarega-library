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

    public static Integer readValueToInteger(Parcel in) {
        Object value = in.readValue(Integer.class.getClassLoader());
        return value != null ? (Integer) value : null;
    }

    public static Double readValueToDouble(Parcel in) {
        Object value = in.readValue(Double.class.getClassLoader());
        return value != null ? (Double) value : null;
    }

    public static Float readValueToFloat(Parcel in) {
        Object value = in.readValue(Float.class.getClassLoader());
        return value != null ? (Float) value : null;
    }

    public static byte[] readValueToByte(Parcel in) {
        Object value = in.readValue(byte[].class.getClassLoader());
        return value != null ? (byte[]) value : null;
    }

    public static Date readValueToDate(Parcel in) {
        return new Date(in.readLong());
    }

    public static Long writeValueToDate(Date value) {
        return (Long) (value != null ? value.getTime() : null);
    }

    public static Long writeValueToBoolean(Boolean value) {
        return (long) (value ? 0 : 1);
    }
}
