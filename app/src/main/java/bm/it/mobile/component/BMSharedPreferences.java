package bm.it.mobile.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class BMSharedPreferences {

    /**
     * Add a Long value into the shared preference
     *
     * @param value   long
     * @param id      value id
     * @param context activity/fragment context
     */
    public static void addLong(Long value, String id, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(id, value);
        editor.apply();
    }

    /**
     * Add a boolean value into the shared preference
     *
     * @param value   true or false
     * @param id      value id
     * @param context activity/fragment context
     */
    public static void addBoolean(Boolean value, String id, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(id, value);
        editor.apply();
    }

    /**
     * Add a string value into the shared preference
     *
     * @param value   string value
     * @param id      value id
     * @param context activity/fragment context
     */
    public static void addString(String value, String id, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(id, value);
        editor.apply();
    }

    /**
     * get a boolean value in the shared preference
     *
     * @param id      value id
     * @param context activity/fragment context
     */
    public static Boolean getBoolean(String id, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(id, false);
    }

    /**
     * get a boolean value in the shared preference
     *
     * @param id      value id
     * @param context activity/fragment context
     */
    public static Boolean getBooleanDefaultTrue(String id, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getBoolean(id, true);
    }

    /**
     * get a long value in the shared preference
     *
     * @param id      value id
     * @param context activity/fragment context
     */
    public static Long getLong(String id, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getLong(id, 0L);
    }

    /**
     * get a string value in the shared preference
     *
     * @param id      value id
     * @param context activity/fragment context
     */
    public static String getString(String id, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(id, "");
    }

    /**
     * remove a value from the shared preference
     *
     * @param id      value id
     * @param context activity/fragment context
     */
    public static void remove(String id, Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(id);
        editor.apply();
    }
}
