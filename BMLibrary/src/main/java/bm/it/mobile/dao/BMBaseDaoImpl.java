package bm.it.mobile.dao;

import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class BMBaseDaoImpl<T, ID> extends com.j256.ormlite.dao.BaseDaoImpl<T, ID> {

    protected BMBaseDatabaseHelper dbHelper;

    protected BMBaseDaoImpl(ConnectionSource connectionSource, Class<T> dataClass, BMBaseDatabaseHelper helper) throws SQLException {
        super(connectionSource, dataClass);
        this.dbHelper = helper;
    }

    protected BMBaseDaoImpl(ConnectionSource connectionSource, Class<T> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}