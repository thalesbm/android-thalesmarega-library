package bm.it.mobile.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;

import java.io.File;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BMBaseDatabaseHelper extends OrmLiteSqliteOpenHelper {
    protected final String TAG = BMBaseDatabaseHelper.class.getSimpleName();

    protected static final AtomicInteger usageCounter = new AtomicInteger(0);
    protected Context context;

    public BMBaseDatabaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
        super(context, databaseName, factory, databaseVersion);
    }

    public BMBaseDatabaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion, int configFileId) {
        super(context, databaseName, factory, databaseVersion, configFileId);
    }

    public BMBaseDatabaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion, File configFile) {
        super(context, databaseName, factory, databaseVersion, configFile);
    }

    public BMBaseDatabaseHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion, InputStream stream) {
        super(context, databaseName, factory, databaseVersion, stream);
    }
}
