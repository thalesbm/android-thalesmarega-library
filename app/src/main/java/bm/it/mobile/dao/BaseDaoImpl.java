package bm.it.mobile.dao;

import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class BaseDaoImpl <T, ID> extends com.j256.ormlite.dao.BaseDaoImpl<T, ID> {

    protected BaseDatabaseHelper dbHelper;

    protected BaseDaoImpl(ConnectionSource connectionSource, Class<T> dataClass, BaseDatabaseHelper helper) throws SQLException {
        super(connectionSource, dataClass);
        this.dbHelper = helper;
    }

    protected BaseDaoImpl(ConnectionSource connectionSource, Class<T> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }
}